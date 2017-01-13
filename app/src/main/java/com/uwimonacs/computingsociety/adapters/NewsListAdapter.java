package com.uwimonacs.computingsociety.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
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
                .inflate(R.layout.frag_news_feed, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsHolder newsHolder, int position){
        NewsItem newsItem = newsItems.get(newsHolder.getAdapterPosition());
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
                    "Today", context.getString(R.string.lorem_ipsum_text_double), String.valueOf(R.drawable.banner), 47);

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
