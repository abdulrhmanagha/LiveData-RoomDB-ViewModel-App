package com.example.asus.test.Model.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.util.Log;

import com.example.asus.test.Application.MyApplication;
import com.example.asus.test.Model.Database.ItemDatabase;
import com.example.asus.test.Model.Entities.Item;

import java.util.List;


public class RepositoryImpl implements Repository{

    private static RepositoryImpl repository = new RepositoryImpl();
    private ItemDatabase itemDB;
    private final String TAG = this.getClass().getName();

    // operations constants
    private static final int INSERT_OPERATION = 0;
    private static final int DELETE_OPERATION = 1;

    // constructor
    private RepositoryImpl(){
        initDB();
    }

    public static Repository getInstance(){
        return repository;
    }

    private void initDB() {
        Log.e(TAG, "_DataBaseInit");
        itemDB = Room.databaseBuilder(MyApplication.getAppContext(),
                ItemDatabase.class, "ItemDatabase").build();
    }

    @Override
    public void addItem(Item item) {
        Log.e(TAG, "_ItemIsAddedToDB");
        new DataBaseOperation(item,INSERT_OPERATION).execute();
    }

    @Override
    public void deleteItem(Item item) {
        Log.e(TAG, "_ItemIsDeletedFromDB");
        new DataBaseOperation(item,DELETE_OPERATION).execute();
    }

    @Override
    public LiveData<List<Item>> getItems() {
        Log.e(TAG, "_GetItemsFromDB");
        return itemDB.itemDao().getItems();
    }

    // Async
    class DataBaseOperation extends AsyncTask<Void,Void,Void> {

        public Item item;
        public int operation;

        public DataBaseOperation(Item item, int operation){
            this.item = item;
            this.operation = operation;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.e(TAG, "_doInBackgroundInvoked");
            // INSERT operation
            if (operation == INSERT_OPERATION) itemDB.itemDao().insert(item);
            // else delete ...
            return null;
        }

    }

}
