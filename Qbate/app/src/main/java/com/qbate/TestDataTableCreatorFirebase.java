package com.qbate;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class TestDataTableCreatorFirebase {
    /* Create topics Table and topic category Maping at firebase*/


    static void createCategoryTable(ArrayList<String> list){
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("category");
        for(String cName:list){
            String id = dbRef.push().getKey();
            CategoryItem obj = new CategoryItem(id,cName);
            dbRef.child(id).setValue(obj);
        }
    }

    static void creatingTopicsTable(String categoryId,String categoryName){
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("topics");
        for(int i=1;i<=10;i++){
            String topicId = dbRef.push().getKey();
            long timestamp = Calendar.getInstance().getTimeInMillis();
            String topicTitle = "Dummy Topic on Category " + categoryName + " with topic Id :" + topicId;
            String topicCategoryId = categoryId;

            TopicItem topicItem = new TopicItem(topicId, topicCategoryId, topicTitle, timestamp, 0, 0, 0);
            Log.d("testing","" + topicId + " " + " " + topicCategoryId + " " + topicTitle + " " + timestamp + " 0 0 0");
            dbRef.child(topicId).setValue(topicItem);
        }
    }
}
