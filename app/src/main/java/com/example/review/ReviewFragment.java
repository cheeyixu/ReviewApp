package com.example.review;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReviewFragment extends Fragment {

    private ArrayAdapter<String> mReviewAdapter;

    public ReviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_review, container, false);

        String[] item = {"Ks","Jes","Ah Bee","Gm","Zach","SJ"};
        List<String> list = new ArrayList<String>(Arrays.asList(item));

        mReviewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_review,R.id.profile_name,list);

        ListView listView = (ListView)rootView.findViewById(R.id.listview_review);
        listView.setAdapter(mReviewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return rootView;
    }
}
