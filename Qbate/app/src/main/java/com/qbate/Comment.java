package com.qbate;

import java.sql.Timestamp;

public class Comment {
    private int commentId;
    private int topicId;
    private int categoryId;
    private int upvotes;
    private int downvotes;
    private int irrelevantCount;
    private String username;
    private String userId;
    private Timestamp timestamp;
    private StringBuffer title;

    public Comment(int commentId, int topicId, int categoryId, int upvotes, int downvotes, int irrelevantCount, String username, String userId, Timestamp timestamp, StringBuffer title) {
        this.commentId = commentId;
        this.topicId = topicId;
        this.categoryId = categoryId;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.irrelevantCount = irrelevantCount;
        this.username = username;
        this.userId = userId;
        this.timestamp = timestamp;
        this.title = title;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getIrrelevantCount() {
        return irrelevantCount;
    }

    public void setIrrelevantCount(int irrelevantCount) {
        this.irrelevantCount = irrelevantCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public StringBuffer getTitle() {
        return title;
    }

    public void setTitle(StringBuffer title) {
        this.title = title;
    }
}
