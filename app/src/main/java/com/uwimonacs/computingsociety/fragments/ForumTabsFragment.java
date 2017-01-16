package com.uwimonacs.computingsociety.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.activities.CreateForumPostActivity;
import com.uwimonacs.computingsociety.activities.EditProfileActivity;
import com.uwimonacs.computingsociety.adapters.ForumTabAdapter;
import com.uwimonacs.computingsociety.util.ScreenUtils;

/**
 * @author sultanofcardio
 */

public class ForumTabsFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ForumTabAdapter adapter;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_forum_tabs, container, false);

        initViews();

        setUpViews();

        return view;
    }

    private void initViews(){
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
    }

    private void setUpViews(){
        setUpPager();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Check for user profile completeness
                startActivity(new Intent(getContext(), CreateForumPostActivity.class));
            }
        });
    }

    private void setUpPager(){
        tabLayout.addTab(tabLayout.newTab().setText("Most Recent"));
        tabLayout.addTab(tabLayout.newTab().setText("Most Popular"));

        adapter = new ForumTabAdapter(getFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Latest");
        tabLayout.getTabAt(1).setText("Popular");
    }

    private void showProfileDialog(){
        ScreenUtils.showDialog(getContext(),
            "Profile Incomplete",
            "You need to complete your profile to start a discussion. Complete it now?",
            "Yes", "No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getContext(), EditProfileActivity.class));
                }
            }, null);
    }
}
