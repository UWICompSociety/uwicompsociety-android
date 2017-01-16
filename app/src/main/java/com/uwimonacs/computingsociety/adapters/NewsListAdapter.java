package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.activities.NewsItemActivity;
import com.uwimonacs.computingsociety.models.NewsItem;

import java.util.List;

/**
 * Created by jawil on 13/1/2017.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsHolder> {
    private List<NewsItem> newsItems;
    private Context context;


    public NewsListAdapter(List<NewsItem> newsItems, Context context){
        this.newsItems = newsItems;
        this.context = context;

        initNews();
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new NewsHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final NewsHolder newsHolder, int position){
        final NewsItem newsItem = newsItems.get(newsHolder.getAdapterPosition());

        newsHolder.title.setText(newsItem.getTitle());
        newsHolder.summary.setText(newsItem.getSummary());

        Picasso.with(context).load(Uri.parse(newsItem.getImage_url())).into(newsHolder.news_image);

        newsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, NewsItemActivity.class);
                intent.putExtra("id", newsItem.getNews_id());
                intent.putExtra("title", newsItem.getTitle());
                intent.putExtra("message", newsItem.getMessage());
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    Pair<View, String> pair = Pair.create((View) newsHolder.news_image,
                            newsHolder.news_image.getTransitionName());
                    Pair<View, String> pair2 = Pair.create((View) newsHolder.summary,
                            newsHolder.summary.getTransitionName());
                    ActivityOptionsCompat options =
                            ActivityOptionsCompat.makeSceneTransitionAnimation((AppCompatActivity)context, pair, pair2);
                    context.startActivity(intent, options.toBundle());
                } else
                    context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return newsItems.size();
    }

    public void initNews(){
        NewsItem newsItem;

        int [] news_ids = {001,002,003};
        int [] user_ids = {100,200,300};
        String [] titles = {"Trump wins election", "Innovative new Mac is a cardboard box", "Gamer Guide"};

        for(int i=0; i < 3; i++){
            newsItem = new NewsItem(news_ids[i], user_ids[i], titles[i], context.getString(R.string.lorem_ipsum_text),
                    "Today", context.getString(R.string.lorem_ipsum_text_double),
                    "android.resource://com.uwimonacs.computingsociety/drawable/banner", 47);

            newsItems.add(newsItem);
        }

    }

    public void update(List<NewsItem> newsItems){
        this.newsItems = newsItems;
        notifyDataSetChanged();
    }

    class NewsHolder extends RecyclerView.ViewHolder{
        TextView title, summary, read_more;
        ImageView news_image;

        NewsHolder(View itemView){
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            summary = (TextView)itemView.findViewById(R.id.summary);
            read_more = (TextView)itemView.findViewById(R.id.read_more);

            news_image = (ImageView)itemView.findViewById(R.id.news_item_image);
        }

    }
}
