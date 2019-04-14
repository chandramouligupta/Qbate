package com.qbate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
        int flag = 0;
        String uid = commentsItemList.get(position).getUserId();
        Log.d("testing20","UID:"+uid);
        TextView commentTitle;
        TextView userName;
        TextView dateTime;
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(context);
        Log.d("testing20",googleSignInAccount.getEmail());
        View v;
        if(uid.equalsIgnoreCase(googleSignInAccount.getEmail())) {
            v = View.inflate(context, R.layout.my_message, null);
            commentTitle = v.findViewById(R.id.my_message_body);
            dateTime = v.findViewById(R.id.my_comment_time);
            commentTitle.setText(commentsItemList.get(position).getCommentTitle());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
            dateTime.setText(sdf.format(commentsItemList.get(position).getTimestamp()));
        }
        else {
            ImageView avatar;
            v = View.inflate(context, R.layout.their_message, null);
            commentTitle = v.findViewById(R.id.their_message_body);
            userName = v.findViewById(R.id.uname);
            avatar = v.findViewById(R.id.avatar);
            dateTime = v.findViewById(R.id.their_comment_time);
            commentTitle.setText(commentsItemList.get(position).getCommentTitle());
            String photoUrl = commentsItemList.get(position).getPhotoUrl();
            if(!photoUrl.equalsIgnoreCase("NO_PROFILE_PIC")) {
                Log.d("testing",commentsItemList.get(position).getPhotoUrl());

                new DownloadImageTask((ImageView) v.findViewById(R.id.avatar))
                        .execute(photoUrl);
            }
            userName.setText(commentsItemList.get(position).getUsername());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
            dateTime.setText(sdf.format(commentsItemList.get(position).getTimestamp()));
        }

        //saving product id to the tag
        v.setTag(commentsItemList.get(position).getCommentId());
        return v;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
