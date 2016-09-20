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
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment {

    private ArrayAdapter<String> mSortSettingsAdapter;

    public SortFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sort, container, false);

        String[] item = {"Ks","Jes","Ah Bee","Gm","Zach","SJ"};
        final List<String> list = new ArrayList<String>(Arrays.asList(item));

        mSortSettingsAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_sort,R.id.sort_list_text,list);

        final ListView listView = (ListView)rootView.findViewById(R.id.listview_sort);
        listView.setAdapter(mSortSettingsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
            }
        });


        return rootView;
    }
}
