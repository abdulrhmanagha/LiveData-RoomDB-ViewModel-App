package com.example.asus.test.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.asus.test.Activities.Adapter.RecyclerViewAdapter;
import com.example.asus.test.Model.Entities.Item;
import com.example.asus.test.R;
import com.example.asus.test.ViewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private RecyclerViewAdapter adapter;
    private List<Item> list;
    private MainActivityViewModel mViewModel;

    // TAG for Logging
    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG,"_ActivityInit");

        // init views and adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        fab = (FloatingActionButton) findViewById(R.id.add_btn);
        fab.setOnClickListener(this);
        list = new ArrayList<>();
        adapter = new RecyclerViewAdapter(list);

        // set adapter and layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        // set view model
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mViewModel.getListItems().observe(this, items -> {
            // update DataSet
            Log.e(TAG,"_AdapterIsUpdated");
            list.clear(); list.addAll(mViewModel.getListItems().getValue());
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onClick(View v) {
        // go to add activity
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
