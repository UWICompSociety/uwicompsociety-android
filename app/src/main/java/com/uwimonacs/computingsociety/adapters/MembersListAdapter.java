package com.uwimonacs.computingsociety.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.Member;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jourdanDunkley on 1/9/2017.
 */
public class MembersListAdapter extends RecyclerView.Adapter<MembersListAdapter.MembersHolder> {

    private List<Member> members;



    public MembersListAdapter(List<Member> members){
        this.members = members;
    }

    @Override
    public MembersHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new MembersHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.members_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MembersHolder holder, int position) {
        Member member = members.get(position);

        holder.memberName.setText(member.getName());
        holder.memberPosition.setText(member.getPosition());
        holder.memberPic.setImageResource(member.getPicId());
    }

    @Override
    public int getItemCount(){return members.size();}

    class MembersHolder extends RecyclerView.ViewHolder{
        TextView memberName, memberPosition;
        ImageView memberPic;

        public MembersHolder(final View itemView){
            super(itemView);

            memberName = (TextView)itemView.findViewById(R.id.memberName);
            memberPosition = (TextView)itemView.findViewById(R.id.memberPosition);
            memberPic = (ImageView)itemView.findViewById(R.id.memberPic);
        }
    }
}
