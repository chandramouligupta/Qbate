package com.qbate;

import java.sql.Timestamp;

public class CommentItem {
    private String commentId;
    private String topicId;
    private String categoryId;
    private int upvotes;
    private int downvotes;
    private int irrelevantCount;
    private String username;
    private String userId;
    private long timestamp;
    private String photoUrl;
    private String commentTitle;

    public CommentItem() {
    }

    public CommentItem(String commentId, String topicId, String categoryId, int upvotes, int downvotes, int irrelevantCount, String username, String userId, long timestamp, String photoUrl, String commentTitle) {
        this.commentId = commentId;
        this.topicId = topicId;
        this.categoryId = categoryId;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.irrelevantCount = irrelevantCount;
        this.username = username;
        this.userId = userId;
        this.timestamp = timestamp;
        this.photoUrl = photoUrl;
        this.commentTitle = commentTitle;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
