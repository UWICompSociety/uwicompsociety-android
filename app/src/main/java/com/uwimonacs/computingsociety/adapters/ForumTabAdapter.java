package com.uwimonacs.computingsociety.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.uwimonacs.computingsociety.fragments.ForumListFragment;

/**
 * @author sultanofcardio
 */

public class ForumTabAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public ForumTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putString("type","Most Recent");
                ForumListFragment latestFragment = new ForumListFragment();
                latestFragment.setArguments(bundle);
                return latestFragment;
            case 1:
                Bundle bundle1 = new Bundle();
                bundle1.putString("type","Most Popular");
                ForumListFragment popularFragment = new ForumListFragment();
                popularFragment.setArguments(bundle1);
                return popularFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
