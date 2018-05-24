package com.example.asus.test.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.asus.test.Model.Entities.Item;
import com.example.asus.test.Model.Repository.RepositoryImpl;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private final String TAG = this.getClass().getName();

    private LiveData<List<Item>> listItems;

    public LiveData<List<Item>> getListItems() {
        if (listItems == null){
            Log.e(TAG, "_ListItemsIsNULL");
            listItems = new MutableLiveData<List<Item>>();
            loadItemsFromRepository();
        }
        Log.e(TAG, "_ReturningFromViewModel");
        return listItems;
    }

    private void loadItemsFromRepository() {
        Log.e(TAG, "_LoadFromDB");
        listItems = RepositoryImpl.getInstance().getItems();
    }
}
