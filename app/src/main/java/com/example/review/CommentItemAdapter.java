package com.example.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by jesmond on 20/9/2016.
 */
public class CommentItemAdapter extends ArrayAdapter {

    private int layout;

    public CommentItemAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        CommentItemViewHolder mainViewholder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            CommentItemViewHolder viewHolder = new CommentItemViewHolder();
            viewHolder.commentLL = (LinearLayout) convertView.findViewById(R.id.list_item_comment);
            viewHolder.commentRCC = (LinearLayout) convertView.findViewById(R.id.comment_rcc);
            convertView.setTag(viewHolder);
        }
        mainViewholder = (CommentItemViewHolder) convertView.getTag();
        final CommentItemViewHolder finalMainViewholder = mainViewholder;
        mainViewholder.commentLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalMainViewholder.commentRCC.getVisibility() == View.GONE){
                    finalMainViewholder.commentLL.setBackgroundColor(0xfffaecec);
                    finalMainViewholder.commentRCC.setVisibility(View.VISIBLE);
                }
                else if (finalMainViewholder.commentRCC.getVisibility() == View.VISIBLE){
                    finalMainViewholder.commentLL.setBackgroundColor(0xffffffff);
                    finalMainViewholder.commentRCC.setVisibility(View.GONE);
                }
            }

        });

        return super.getView(position, convertView, parent);
    }

    public class CommentItemViewHolder{
        LinearLayout commentLL, commentRCC;
    }
}
