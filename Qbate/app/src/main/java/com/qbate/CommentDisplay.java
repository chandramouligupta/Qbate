package com.qbate;

import android.app.DownloadManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class CommentDisplay extends AppCompatActivity {

    private Context commentsDisplayContext;
    private String categoryId;
    private String topicId;
    private GoogleSignInAccount googleSignInAccount;
    private ListView listView;
    private EditText editText;
    private Button sendButton;
    private ArrayList<CommentItem> commentsItemList;
    private CommentListAdapter commentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.comment_ui_based_activity);
        topicId = getIntent().getStringExtra("topicId");
        categoryId = getIntent().getStringExtra("categoryId");
        googleSignInAccount = (GoogleSignInAccount) getIntent().getSerializableExtra("signInObject");
        listView = findViewById(R.id.messages_view);
        editText = findViewById(R.id.editText);
        ImageButton ib = findViewById(R.id.send_comment);
        commentsDisplayContext = this;
        commentsItemList = new ArrayList<CommentItem>();

        /*setContentView(R.layout.activity_comment_display);
        topicId = getIntent().getStringExtra("topicId");
        categoryId = getIntent().getStringExtra("categoryId");
        listView = findViewById(R.id.comment_list);
        editText = findViewById(R.id.mycomment_edittext);
        sendButton = findViewById(R.id.comment_send_button);
        commentsDisplayContext = this;
        commentsItemList = new ArrayList<CommentItem>();*/

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String commentTitle = editText.getText().toString();
                editText.setText("");
                if(commentTitle != null && !commentTitle.equalsIgnoreCase("")){
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("comments");
                    String commentId = dbRef.push().getKey();
                    //String topicId;
                    //String categoryId;
                    int upvotes = 0;
                    int downvotes = 0;
                    int irrelevantCount = 0;
                    String username = GoogleSignIn.getLastSignedInAccount(commentsDisplayContext).getDisplayName();
                    String userId =  GoogleSignIn.getLastSignedInAccount(commentsDisplayContext).getEmail();
                    long timestamp = Calendar.getInstance().getTimeInMillis();
                    CommentItem ci = new CommentItem(commentId,topicId,categoryId,upvotes,
                            downvotes,irrelevantCount,username,userId,timestamp,commentTitle);
                    dbRef.child(commentId).setValue(ci);
                }
            }
        });

        Query query = FirebaseDatabase.getInstance().getReference("comments")
                .orderByChild("topicId").equalTo(topicId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentsItemList.clear();
                for(DataSnapshot item:dataSnapshot.getChildren()){
                    CommentItem ci = item.getValue(CommentItem.class);
                    Log.d("testing20",ci.getCategoryId() + " " + ci.getTopicId() + " " + ci.getCommentTitle());
                    commentsItemList.add(ci);
                }
                commentListAdapter = new CommentListAdapter(commentsDisplayContext,commentsItemList);
                listView.setAdapter(commentListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
