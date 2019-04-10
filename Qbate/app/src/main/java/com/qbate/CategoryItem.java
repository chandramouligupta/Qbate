package com.qbate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CategoryItem extends AppCompatActivity {

    private int categoryId;
    private String categoryName;

    public CategoryItem(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
