package com.uwimonacs.computingsociety.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.adapters.BlogListAdapter;
import com.uwimonacs.computingsociety.fragments.BlogFragment;
import com.uwimonacs.computingsociety.models.BlogPost;
import com.uwimonacs.computingsociety.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class BlogActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener {
    private View getPosting;
    private RecyclerView recyclerView;
    private List<BlogPost> posts;
    private SearchView searchView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        initViews();

        setUpViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blogs, menu);

        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search Blog Posts");

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.setQuery("", false);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.post:
                newPost();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initViews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        getPosting = findViewById(R.id.get_posting);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        posts = new ArrayList<>();
    }

    @SuppressWarnings("ConstantConditions")
    private void setUpViews(){
        setUpRecyclerView();

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("John Doe's Blog"); // TODO: Replace with topic

        getPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPost();
            }
        });
    }

    private void setUpRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BlogListAdapter(posts, this, false));
        if(posts.size() > 0){
            getPosting.setVisibility(View.GONE);
        }
    }

    private void newPost(){
        startActivity(new Intent(this, CreateBlogPostActivity.class));
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
