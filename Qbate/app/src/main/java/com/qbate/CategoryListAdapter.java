package com.qbate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryListAdapter extends BaseAdapter {

    private Context context;
    private List<CategoryItem> categoryItemsList;

    public CategoryListAdapter(Context context, List<CategoryItem> categoryItemsList) {
        this.categoryItemsList = categoryItemsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return categoryItemsList.get(position).getCategoryId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context,R.layout.category_item,null);
        TextView categoryItem = v.findViewById(R.id.category_testing);

        //setting data to the list

        categoryItem.setText("Category ID:" + categoryItemsList.get(position).getCategoryId()
                       + " Category Name:" + categoryItemsList.get(position).getCategoryName());


        //saving product id to the tag

        v.setTag(categoryItemsList.get(position).getCategoryId());
        return v;
    }
}
