package com.qbate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TopicsDisplay extends AppCompatActivity {


    private int categoryId;
    private String categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics_display);
        categoryId = Integer.parseInt(getIntent().getStringExtra("categoryId"));
        categoryName = getIntent().getStringExtra("categoryName");
        getTopicsDataFromFirebase(categoryId,categoryName);
    }

    protected void getTopicsDataFromFirebase(int categoryId , String categoryName){
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("topics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Log.d("testing","Topics Json is:" + dataSnapshot.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
