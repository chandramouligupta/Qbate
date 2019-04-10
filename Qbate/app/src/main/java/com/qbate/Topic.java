package com.qbate;

import java.sql.Timestamp;

public class Topic {
    private int topicId;
    private int topicategoryId;
    private String title;
    private Timestamp timestamp;
    private int rank;

    public Topic(int topicId, int topicategoryId, String title, Timestamp timestamp, int rank) {
        this.topicId = topicId;
        this.topicategoryId = topicategoryId;
        this.title = title;
        this.timestamp = timestamp;
        this.rank = rank;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getTopicategoryId() {
        return topicategoryId;
    }

    public void setTopicategoryId(int topicategoryId) {
        this.topicategoryId = topicategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
