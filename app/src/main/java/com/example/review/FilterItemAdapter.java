package com.example.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jesmond on 18/9/2016.
 */
public class FilterItemAdapter extends ArrayAdapter {

    private int layout;
    private List<String> mObjects;

    public FilterItemAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        layout = resource;
        mObjects = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        FilterItemViewHolder mainViewholder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            FilterItemViewHolder viewHolder = new FilterItemViewHolder();
            viewHolder.attr = (TextView) convertView.findViewById(R.id.filter_list_text);
            viewHolder.min = (EditText) convertView.findViewById(R.id.min_attr);
            viewHolder.max = (EditText) convertView.findViewById(R.id.max_attr);
            viewHolder.clear = (Button) convertView.findViewById(R.id.clear_button);
            convertView.setTag(viewHolder);
        }
        mainViewholder = (FilterItemViewHolder) convertView.getTag();
        mainViewholder.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObjects.remove(position);
                notifyDataSetChanged();
            }
        });

        return super.getView(position, convertView, parent);
    }

    public class FilterItemViewHolder{
        TextView attr;
        EditText min;
        EditText max;
        Button clear;
    }
}
