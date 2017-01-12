package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.Member;
import com.uwimonacs.computingsociety.models.User;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jourdanDunkley on 1/9/2017.
 */
public class MembersListAdapter extends RecyclerView.Adapter<MembersListAdapter.MembersHolder> {

    private List<User> members;
    private Context context;


    public MembersListAdapter(List<User> members, Context context){
        this.members = members;
        this.context = context;
    }

    @Override
    public MembersHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new MembersHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.members_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MembersHolder holder, int position) {
        User member = members.get(position);
        String fullName = member.getFirst_name() + " " + member.getLast_name();
        holder.memberName.setText(fullName);
        holder.memberPosition.setText(member.getPosition());
        Picasso.with(context).load(Uri.parse(member.getImage_url())).into(holder.memberPic);
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

    public void update (List<User> members){
        this.members = members;
        notifyDataSetChanged();
    }
}
