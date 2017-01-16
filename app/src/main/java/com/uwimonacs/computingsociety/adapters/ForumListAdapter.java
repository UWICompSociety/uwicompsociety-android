package com.uwimonacs.computingsociety.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.models.ForumPost;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sultanofcardio
 */

public class ForumListAdapter extends RecyclerView.Adapter<ForumListAdapter.ForumListHolder>{
    private Context context;
    private List<ForumPost> forumPosts;

    public ForumListAdapter(Context context, ArrayList<ForumPost> forumPosts) {
        this.context = context;
        this.forumPosts = forumPosts;

        initExampleData();
    }

    @Override
    public ForumListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForumListHolder(LayoutInflater.from(context)
                .inflate(R.layout.forum_list_item, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ForumListHolder holder, int position) {
        ForumPost post = forumPosts.get(holder.getAdapterPosition());

        holder.title.setText(post.getTopic());
        holder.name.setText("John Doe");
        holder.date.setText(post.getDate());
        holder.message.setText(post.getMessage());

        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Launch user profile activity
                Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG).show();
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Launch user profile activity
                Snackbar.make(view, "Coming soon", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return forumPosts.size();
    }

    private void initExampleData(){
        for(int i = 0; i< 10; i++){
            ForumPost post = new ForumPost(0, 0, "I need help with an assignment",
                    "01/01/2017 at 12:00pm",
                    context.getString(R.string.lorem_ipsum_text),
                    0, 0, 0);
            forumPosts.add(post);
        }
    }

    class ForumListHolder extends RecyclerView.ViewHolder{
        ImageView avatar;
        TextView title, message, name, date;

        public ForumListHolder(View itemView) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            title = (TextView) itemView.findViewById(R.id.title);
            message = (TextView) itemView.findViewById(R.id.message);
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
