package com.qbate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TopicsDisplay extends AppCompatActivity {


    private int categoryId;
    private String categoryName;
    private ListView listView;
    private ArrayList<TopicItem> topicsList;
    private ArrayList<TopicCategoryMapTableItem> mapTableItemsList;
    private Context topicDisplayContext;
    private TopicListAdapter topicsListAdapter;
    DatabaseReference topicTableRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_display);
        categoryId = Integer.parseInt(getIntent().getStringExtra("categoryId"));
        categoryName = getIntent().getStringExtra("categoryName");
        listView = findViewById(R.id.topics_list);
        topicDisplayContext = this;
        getTopicsDataFromFirebase(categoryId,categoryName);
    }

    protected void getTopicsDataFromFirebase(final int categoryId , String categoryName){
        mapTableItemsList = new ArrayList<TopicCategoryMapTableItem>();
        topicsList = new ArrayList<TopicItem>();
        final DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("topicCategoryMappingTable");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("testing","Topics Json is:" + dataSnapshot.toString());
                if(topicsList != null)
                    topicsList.clear();
                if(mapTableItemsList != null){
                    mapTableItemsList.clear();
                }
                for(DataSnapshot postSnapShot:dataSnapshot.getChildren()){
                    int cid = Integer.parseInt(postSnapShot.child("categoryId").getValue().toString());
                    int topicId = Integer.parseInt(postSnapShot.child("topicId").getValue().toString());
                    mapTableItemsList.add(new TopicCategoryMapTableItem(cid,topicId));
                }

                //Getting Topic Rows from Database for given CategoryId
                DatabaseReference topicTableRef = FirebaseDatabase.getInstance().getReference();
                for(TopicCategoryMapTableItem item:mapTableItemsList){
                    if(item.getCategoryId() == categoryId) {
                        //getting data from topics table only for the selected categoryId

                        topicTableRef.child("topics").child(""+item.getTopicId()).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot != null) {
                                    TopicItem obj = dataSnapshot.getValue(TopicItem.class);
                                    topicsList.add(obj);
                                    Log.d("testing",obj.getTopicTitle());
                                    topicsListAdapter = new TopicListAdapter(topicDisplayContext,topicsList);
                                    listView.setAdapter(topicsListAdapter);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
                Log.d("testing2","topicList Size"+topicsList.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
