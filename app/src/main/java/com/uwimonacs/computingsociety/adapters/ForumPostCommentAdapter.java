package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.constants.CommentType;
import com.uwimonacs.computingsociety.models.Comment;
import com.uwimonacs.computingsociety.models.User;

import java.util.List;

/**
 * @author sultanofcardio
 */

public class ForumPostCommentAdapter extends RecyclerView.Adapter<ForumPostCommentAdapter.ForumPostCommentHolder> {
    private Context context;
    private List<Comment> comments;

    public ForumPostCommentAdapter(Context context, List<Comment> comments){
        this.context = context;
        this.comments = comments;

        initExampleData();
    }

    @Override
    public ForumPostCommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForumPostCommentHolder(LayoutInflater.from(context)
                .inflate(R.layout.comment_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ForumPostCommentHolder holder, int position) {
        final Comment comment = comments.get(holder.getAdapterPosition());
//        User user = User.getUser(comment.getUser_id());
        User user = sampleUser();

        Picasso.with(context).load(user.getImageUrl()).into(holder.image);

        String name = user.getFirstName() + " " + user.getLastName();
        holder.name.setText(name);

        holder.comment.setText(comment.getMessage());
        holder.date.setText(comment.getDate());
        holder.numLikes.setText(String.valueOf(comment.getNum_likes()));
        holder.numDislikes.setText(String.valueOf(comment.getNum_dislikes()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Fix bug with multiple likes + un-liking
                int numLikes = comment.getNum_likes() + 1;
                comment.setNum_likes(numLikes);
                holder.numLikes.setText(String.valueOf(numLikes));
            }
        });

        holder.btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Fix bug with multiple dislikes + un-disliking
                int numDislikes = comment.getNum_dislikes() + 1;
                comment.setNum_dislikes(numDislikes);
                holder.numDislikes.setText(String.valueOf(numDislikes));
            }
        });
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void update(List<Comment> comments){
        this.comments = comments;
    }

    public void add(Comment comment){
        this.comments.add(comment);
        notifyDataSetChanged();
    }

    private void initExampleData(){
        for(int i = 0; i < 10; i++){
            Comment comment = new Comment(i, 0, CommentType.FORUMPOST_COMMENT,
                    0, context.getString(R.string.lorem_ipsum_text),
                    "07/01/2017 at 12:00pm", 0, 0);
            comments.add(comment);
        }
    }

    private User sampleUser(){
        return new User(0, "someone@example.com", "John", "Doe", "john_doe", "member",
                "https://pbs.twimg.com/profile_images/3309741408/eff94615a3653c01a9d5a178ced7fbb5_400x400.jpeg");
    }

    class ForumPostCommentHolder extends RecyclerView.ViewHolder{
        ImageView image, btnLike, btnDislike;
        TextView name, comment, date, numLikes, numDislikes;

        ForumPostCommentHolder(View itemView) {
            super(itemView);

            initViews();
        }

        void initViews(){
            image = (ImageView) itemView.findViewById(R.id.image);
            btnLike = (ImageView) itemView.findViewById(R.id.btn_like);
            btnDislike = (ImageView) itemView.findViewById(R.id.btn_dislike);
            name = (TextView) itemView.findViewById(R.id.user);
            comment = (TextView) itemView.findViewById(R.id.message);
            date = (TextView) itemView.findViewById(R.id.date);
            numLikes = (TextView) itemView.findViewById(R.id.num_like);
            numDislikes = (TextView) itemView.findViewById(R.id.num_dislike);
        }
    }
}
