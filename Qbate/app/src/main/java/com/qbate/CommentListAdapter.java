package com.qbate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CommentItem> commentsItemList;

    public CommentListAdapter(Context context, ArrayList<CommentItem> commentsItemList) {
        this.context = context;
        this.commentsItemList = commentsItemList;
    }

    @Override
    public int getCount() {
        return commentsItemList.size();
    }

    @Override
    public Object getItem(int pos) {
        return commentsItemList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(context,R.layout.comment_item,null);
        TextView commentItem = v.findViewById(R.id.comment_title);

        //setting data to the list

        commentItem.setText(commentsItemList.get(position).getCommentTitle());

        //saving product id to the tag

        v.setTag(commentsItemList.get(position).getCommentId());
        return v;
    }
}
