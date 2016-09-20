package com.example.review;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilterFragment extends Fragment implements OnItemSelectedListener {

    private Spinner catSpinner, attrSpinner;
    private ListView filterList;
    private List<String> filterItem = new ArrayList<String>();
    private FilterItemAdapter filterItemAdapter;
    private String oldItem;

    public FilterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_filter, container, false);

        //Filter Items
        filterList = (ListView) view.findViewById(R.id.filter_listview);

        filterItemAdapter = new FilterItemAdapter(getContext(), R.layout.list_item_filter, R.id.filter_list_text, filterItem);
        filterList.setAdapter(filterItemAdapter);

        //Dropdown Menu
        catSpinner  = (Spinner) view.findViewById(R.id.spinner_category);
        attrSpinner = (Spinner) view.findViewById(R.id.spinner_attr);

        List<String> category = new ArrayList<String>();
        category.add("Any");
        category.add("Electronics");
        category.add("Books");
        category.add("Restaurants");

        ArrayAdapter<String> catAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, category);
        catSpinner.setAdapter(catAdapter);

        catSpinner.setOnItemSelectedListener(this);
        attrSpinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner_category:
                HashMap<String, List<String>> attr = new HashMap<String, List<String>>();

                List<String> electronic = new ArrayList<String>();
                electronic.add("Performance");
                electronic.add("Battery Life");

                List<String> books = new ArrayList<String>();
                books.add("Books attr 1");
                books.add("Books attr 2");

                List<String> restaurant = new ArrayList<String>();
                restaurant.add("Food");
                restaurant.add("Ambience");

                attr.put("Electronics", electronic);
                attr.put("Books", books);
                attr.put("Restaurants", restaurant);

                String selectedCat = catSpinner.getSelectedItem().toString();

                List<String> attribute = new ArrayList<String>();
                attribute.add("Attributes");

                if (selectedCat != "Any") {
                    attribute.addAll(attr.get(selectedCat));
                }

                ArrayAdapter<String> attrAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, attribute);
                attrSpinner.setAdapter(attrAdapter);
                attrAdapter.notifyDataSetChanged();

                //clear items if category is changed
                if (oldItem != null && oldItem != selectedCat){
                    filterItem.clear();
                    filterItemAdapter.notifyDataSetChanged();
                }
                oldItem = selectedCat;

                break;
            case R.id.spinner_attr:
                String selectedAttr = attrSpinner.getSelectedItem().toString();

                if (selectedAttr != "Attributes"){
                    filterItem.add(selectedAttr);
                    filterItemAdapter.notifyDataSetChanged();
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        ;
    }

}
