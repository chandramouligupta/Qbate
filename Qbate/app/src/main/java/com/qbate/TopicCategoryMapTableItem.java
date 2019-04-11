package com.qbate;

public class TopicCategoryMapTableItem {
    private int categoryId;
    private int topicId;

    public TopicCategoryMapTableItem(int categoryId, int topicId) {
        this.topicId = topicId;
        this.categoryId = categoryId;
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
}
