package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.activities.BlogPostActivity;
import com.uwimonacs.computingsociety.models.BlogPost;

import java.util.List;

/**
 * @author sultanofcardio
 */

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.BlogHolder> {
    private List<BlogPost> posts;
    private Context context;

    public BlogListAdapter(List<BlogPost> posts, Context context, boolean init){
        this.posts = posts;
        this.context = context;

        if(init)
            initExampleData();
    }

    @Override
    public BlogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         return new BlogHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.blog_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BlogHolder holder, int position) {
        BlogPost post = posts.get(holder.getAdapterPosition());

        holder.title.setText(post.getTitle());
        holder.summary.setText(post.getMessage());

        //Wouldn't use Uri.parse() with regular URL
        Picasso.with(context).load(Uri.parse(post.getImageUrl())).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private void initExampleData(){
        for(int i=0; i< 10; i++){
            BlogPost post = new BlogPost(i, 0, 0,
                    "Why I think Object-Oriented Programming is Useless",
                    "Just now",
                    context.getString(R.string.lorem_ipsum_text),
                    "android.resource://com.uwimonacs.computingsociety/drawable/oop",
                    0, 0, 0);
            this.posts.add(post);
        }
    }

    public void update(List<BlogPost> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    class BlogHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, summary, readMore;

        BlogHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            summary = (TextView) itemView.findViewById(R.id.summary);
            readMore = (TextView) itemView.findViewById(R.id.read_more);

            readMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO: Pass intent extras
                    context.startActivity(new Intent(context, BlogPostActivity.class));
                }
            });
        }
    }
}
