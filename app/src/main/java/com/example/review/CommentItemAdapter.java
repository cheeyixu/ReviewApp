package com.example.review;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
            viewHolder.rate = (TextView) convertView.findViewById(R.id.comment_rate);
            viewHolder.reply = (TextView) convertView.findViewById(R.id.comment_reply);
            viewHolder.copy = (TextView) convertView.findViewById(R.id.comment_copy);
            convertView.setTag(viewHolder);
        }
        mainViewholder = (CommentItemViewHolder) convertView.getTag();
        final CommentItemViewHolder finalMainViewholder = mainViewholder;

        mainViewholder.commentLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalMainViewholder.commentRCC.getVisibility() == View.INVISIBLE){
                    finalMainViewholder.commentLL.setBackgroundColor(0xfffaecec);
                    finalMainViewholder.commentRCC.setVisibility(View.VISIBLE);

                }
                else if (finalMainViewholder.commentRCC.getVisibility() == View.VISIBLE){
                    finalMainViewholder.commentLL.setBackgroundColor(0xffffffff);
                    finalMainViewholder.commentRCC.setVisibility(View.GONE);
                }
            }

        });

        mainViewholder.reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = parent.getContext();
                FragmentManager fm = ((Activity) context).getFragmentManager();

                CommentDialog commentDialog = CommentDialog.newInstance("Reply");
                commentDialog.show(fm, "Reply");

            }
        });

        mainViewholder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Comment copied", Toast.LENGTH_SHORT).show();
            }
        });

        return super.getView(position, convertView, parent);
    }

    public class CommentItemViewHolder{
        LinearLayout commentLL, commentRCC;
        TextView rate, reply, copy;
    }
}
