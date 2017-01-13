package com.uwimonacs.computingsociety.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.uwimonacs.computingsociety.R;
import com.uwimonacs.computingsociety.fragments.BlogFragment;
import com.uwimonacs.computingsociety.fragments.MembersListFragment;
import com.uwimonacs.computingsociety.fragments.ProjectListFragment;
import com.uwimonacs.computingsociety.models.User;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
        NavigationView.OnNavigationItemSelectedListener{
    private View fragment;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private SearchView searchView;
    private CircleImageView avatar;
    private TextView name, email;
    private User user;

    private BlogFragment blogFragment;
    private MembersListFragment membersListFragment;
    private ProjectListFragment projectListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setUpViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search News Feed");

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.setQuery("", false);
                return true;
            }
        });

        setDefaultFragment();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START, true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initViews(){
        fragment = findViewById(R.id.fragment);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_drawer);
        avatar = (CircleImageView) navigationView.getHeaderView(0).findViewById(R.id.avatar);
        name = (TextView) navigationView.getHeaderView(0).findViewById(R.id.header_username);
        email = (TextView) navigationView.getHeaderView(0).findViewById(R.id.header_email);
    }

    public void setUpViews(){
        setUpNavDrawer();

        setUpActionBar();
    }

    public void setUpActionBar(){
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setTitle("News Feed");
            actionBar.setDisplayHomeAsUpEnabled(true);
            ActionBarDrawerToggle toggle =
                    new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
            toggle.setDrawerIndicatorEnabled(true);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
    }

    public void setUpNavDrawer(){
        if(user != null) {
            if(!TextUtils.isEmpty(user.getFirstName()) || !TextUtils.isEmpty(user.getLastName()))
                ((TextView)navigationView.getHeaderView(0).findViewById(R.id.header_username))
                        .setText(user.getFirstName() + " " + user.getLastName());

            if(!TextUtils.isEmpty(user.getEmail()))
                ((TextView)navigationView.getHeaderView(0).findViewById(R.id.header_email)).setText(user.getEmail());
        }

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainActivity.this.startActivity(new Intent(MainActivity.this, UserProfileAcivity.class));
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setDefaultFragment(){
        navigationView.setCheckedItem(R.id.news_feed);
        navigationView.getMenu().performIdentifierAction(R.id.news_feed, 0);
    }

    private void setCurrentFragment(Fragment currentFragment, String title){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, currentFragment)
                .commit();
        actionBar.setTitle(title);
        searchView.setQueryHint("Search " + title);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // TODO: Handle search query
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.news_feed:
                drawerLayout.closeDrawers();
                return true;
            case R.id.forums:
                drawerLayout.closeDrawers();
                return true;
            case R.id.blogs:
                blogFragment = new BlogFragment();
                setCurrentFragment(blogFragment, "Blogs");
                drawerLayout.closeDrawers();
                return true;
            case R.id.projects:
                projectListFragment = new ProjectListFragment();
                setCurrentFragment(projectListFragment, "Projects");
                drawerLayout.closeDrawers();
                return true;
            case R.id.members:
                membersListFragment = new MembersListFragment();
                setCurrentFragment(membersListFragment, "Society Members");
                drawerLayout.closeDrawers();
                return true;
            case R.id.settings:
                drawerLayout.closeDrawers();
                return true;
            default:
                return false;
        }
    }
}
