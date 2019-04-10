package com.qbate;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TestTopicTableCreatorFirebase {
    static int counter = 1;


    static void creatingTopicsTable(int categoryId,String categoryName,DatabaseReference dbRef){
        for(int i=1;i<=10;i++,counter++){
            long timestamp = Calendar.getInstance().getTimeInMillis();
            String topicTitle = "Dummy Topic on Category " + categoryName + " with topic Id :" + i;
            int topicCategoryId = categoryId;

            TopicItem topicItem = new TopicItem(counter, topicCategoryId, topicTitle, timestamp, 0, 0, 0);
            Log.d("testing","" + counter + " " + " " + topicCategoryId + " " + topicTitle + " " + timestamp + " 0 0 0");
            dbRef.child("topics").child(""+counter).setValue(topicItem);
        }
    }
}
