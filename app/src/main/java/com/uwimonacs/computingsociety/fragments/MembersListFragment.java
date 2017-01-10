package com.uwimonacs.computingsociety.fragments;

import android.content.Context;
import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.MembersListAdapter;
import com.uwimonacs.computingsociety.models.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jourdanDunkley on 1/9/2017.
 */
public class MembersListFragment extends Fragment {

    Context context;
    private MembersListAdapter adapter;
    private RecyclerView recyclerview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = (View)inflater.inflate(R.layout.members_list, container, false);
        recyclerview = (RecyclerView)rootView.findViewById(R.id.memberRecycler);
        adapter = new MembersListAdapter(getData());
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public static List<Member> getData(){
        List<Member> testData = new ArrayList<>();
        String[] testNames = {"Matthew Stone", "Kenroy Gobourne", "Jourdan Dunkley", "John Smith"};
        String[] testPositions = {"President", "Vice President", "Member", "Member"};
        int[] testPicIds = {R.drawable.account_black, R.drawable.account_black, R.drawable.account_black
                                     ,R.drawable.account_black};
        for(int i=0;i<testNames.length && i<testPositions.length && i<testPicIds.length; i++){
            Member testMember = new Member(testNames[i], testPositions[i], testPicIds[i]);
            testData.add(testMember);
        }
        return testData;
    }
}









