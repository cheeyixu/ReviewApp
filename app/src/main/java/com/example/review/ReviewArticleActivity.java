package com.example.review;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));

        TextView reviewer = (TextView) findViewById(R.id.article_profile_name);
        reviewer.setText(intent.getStringExtra("reviewer"));

        TextView stars = (TextView) findViewById(R.id.article_score3);
        TextView votes = (TextView) findViewById(R.id.article_score2);
        TextView likes = (TextView) findViewById(R.id.article_score1);

        stars.setText("4.3");
        votes.setText("12321");
        likes.setText("123233");

        final LinearLayout articleLL = (LinearLayout) findViewById(R.id.article_ll);

        if (articleLL != null) {
            articleLL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout articleRCC = (LinearLayout) findViewById(R.id.article_rcc);

                    if (articleRCC.getVisibility() == View.GONE) {
                        articleLL.setBackgroundColor(0xfffef6ec);
                        articleRCC.setVisibility(View.VISIBLE);
                    }
                    else if (articleRCC.getVisibility() == View.VISIBLE) {
                        articleLL.setBackgroundColor(0xfffefaf4);
                        articleRCC.setVisibility(View.GONE);
                    }
                }
            });
        }

        TextView copyArticleTV = (TextView) findViewById(R.id.article_copy);

        if (copyArticleTV != null) {
            copyArticleTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ReviewArticleActivity.this , "Article copied", Toast.LENGTH_SHORT).show();
                }
            });
        }


        TextView commentArticleTV = (TextView) findViewById(R.id.article_comment);

        if (commentArticleTV != null) {
            commentArticleTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommentDialog commentDialog = CommentDialog.newInstance("Comment");
                    commentDialog.show(getFragmentManager(), "commentdialog");
                }
            });
        }

        final String[] item = {"Ks","Jes","Ah Bee","Gm","Zach","SJ"};
        List<String> list = new ArrayList<String>(Arrays.asList(item));

        CommentItemAdapter comment = new CommentItemAdapter(this, R.layout.list_item_comment,R.id.comment_user,list);
        final MyListView listView = (MyListView) findViewById(R.id.comment_listview);
        listView.setAdapter(comment);

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
