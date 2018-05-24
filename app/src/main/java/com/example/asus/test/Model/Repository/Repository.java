package com.example.asus.test.Model.Repository;

import android.arch.lifecycle.LiveData;
import com.example.asus.test.Model.Entities.Item;
import java.util.List;

public interface Repository {

    void addItem(Item item);
    void deleteItem(Item item);
    LiveData<List<Item>> getItems();

}
