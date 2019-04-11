package com.qbate;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TestTopicTableCreatorFirebase {
    /* Create topics Table and topic category Maping at firebase*/
    static int topicCounter = 1;
    static int topicCategoryMappingCounter = 1;

    static void creatingTopicsTable(int categoryId,String categoryName,DatabaseReference dbRef){
        for(int i=1;i<=10;i++,topicCounter++){
            int topicId = topicCounter;
            long timestamp = Calendar.getInstance().getTimeInMillis();
            String topicTitle = "Dummy Topic on Category " + categoryName + " with topic Id :" + topicId;
            int topicCategoryId = categoryId;

            TopicItem topicItem = new TopicItem(topicId, topicCategoryId, topicTitle, timestamp, 0, 0, 0);
            Log.d("testing","" + topicCounter + " " + " " + topicCategoryId + " " + topicTitle + " " + timestamp + " 0 0 0");
            mappingTableCreator(categoryId,topicCounter,dbRef);
            dbRef.child("topics").child(""+topicCounter).setValue(topicItem);
        }
    }

    static void mappingTableCreator(int categoryId,int topicId,DatabaseReference dbRef){
        TopicCategoryMapTableItem obj = new TopicCategoryMapTableItem(categoryId, topicId);
        dbRef.child("topicCategoryMappingTable").child(""+topicCategoryMappingCounter++).setValue(obj);
    }
}
