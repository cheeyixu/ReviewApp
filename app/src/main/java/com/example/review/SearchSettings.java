package com.example.review;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * Created by jesmond on 20/7/2016.
 */
public class SearchSettings extends android.support.v4.app.DialogFragment{

    private TabHost mTabHost;

    public Dialog onCreateDialog(final Bundle savedInstanceState)
    {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.search_settings, null);
        mTabHost = (TabHost)view.findViewById(android.R.id.tabhost);

        mTabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = mTabHost.newTabSpec("filter");
        tabSpec.setContent(R.id.filter_tab);
        tabSpec.setIndicator("Filter by");
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec("sort");
        tabSpec.setContent(R.id.sort_tab);
        tabSpec.setIndicator("Sort by");
        mTabHost.addTab(tabSpec);



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        Dialog dialog = builder.create();

        return dialog;
    }


}
