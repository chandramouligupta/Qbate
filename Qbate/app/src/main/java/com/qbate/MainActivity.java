package com.qbate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static Context mainActivityContext;

    private CategoryListAdapter categoryListAdapter;
    private ArrayList<CategoryItem> categoryItemsList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityContext =this;
        listView = findViewById(R.id.category_list);

        /*Cursor result = new DatabaseHelper(this).getCategoryTableData();
        while(result.moveToNext()){
            categoryItemsList.add(new CategoryItem(Integer.parseInt(result.getString(0)),
                    result.getString(1)));
        }*/

        categoryItemsList = new ArrayList<CategoryItem>();
        getCategoryData();
        Log.d("testing","List Size:" + categoryItemsList.size());
        //categoryListAdapter = new CategoryListAdapter(this,categoryItemsList);
        //listView.setAdapter(categoryListAdapter);
    }

    private void getCategoryData(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("category");
        // Read from the database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot postSnapShot:dataSnapshot.getChildren()){
                    int categoryId = Integer.parseInt(postSnapShot.child("category_id").getValue().toString());
                    String categoryName = postSnapShot.child("category_name").getValue().toString();
                    Log.d("testing","CategoryId:"+categoryId + " CategoryName:"+categoryName);
                    categoryItemsList.add(new CategoryItem(categoryId,categoryName));
                }
                categoryListAdapter = new CategoryListAdapter(mainActivityContext,categoryItemsList);
                listView.setAdapter(categoryListAdapter);
                Log.d("testing", "Value is: " + dataSnapshot.toString());

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("testing", "Failed to read value.", error.toException());
            }
        });
    }
}
