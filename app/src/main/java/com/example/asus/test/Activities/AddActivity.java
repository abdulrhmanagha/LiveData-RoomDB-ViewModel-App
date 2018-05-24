package com.example.asus.test.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.test.Model.Entities.Item;
import com.example.asus.test.Model.Repository.RepositoryImpl;
import com.example.asus.test.R;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText title;
    private EditText body;
    private FloatingActionButton fab;

    private final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Log.e(TAG,"_ActivityInit");

        // init vars
        title = (EditText) findViewById(R.id.title);
        body = (EditText) findViewById(R.id.body);
        fab = (FloatingActionButton) findViewById(R.id.add_btn);

        // set listener to FAB
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "_onClickInvoked");
        RepositoryImpl.getInstance().addItem(new Item(title.getText().toString(), body.getText().toString()));
        // show toast
        Toast.makeText(AddActivity.this,"Record Added", Toast.LENGTH_SHORT).show();
        // get back to main activity
        finish();
    }
}
