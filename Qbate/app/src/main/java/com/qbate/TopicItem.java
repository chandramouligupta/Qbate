package com.qbate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Timestamp;

public class TopicItem {
    private String topicId;
    private String topicCategoryId;
    private String topicTitle;
    private long timestamp;
    private int upVotes;
    private int downVotes;
    private int irrelevantCount;

    public TopicItem() {
    }

    public TopicItem(String topicId, String topicCategoryId, String topicTitle, long timestamp, int upVotes, int downVotes, int irrelevantCount) {
        this.topicId = topicId;
        this.topicCategoryId = topicCategoryId;
        this.topicTitle = topicTitle;
        this.timestamp = timestamp;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.irrelevantCount = irrelevantCount;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicCategoryId() {
        return topicCategoryId;
    }

    public void setTopicCategoryId(String topicCategoryId) {
        this.topicCategoryId = topicCategoryId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public int getIrrelevantCount() {
        return irrelevantCount;
    }

    public void setIrrelevantCount(int irrelevantCount) {
        this.irrelevantCount = irrelevantCount;
    }
}
