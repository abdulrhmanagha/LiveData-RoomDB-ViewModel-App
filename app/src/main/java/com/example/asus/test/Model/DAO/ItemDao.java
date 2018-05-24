package com.example.asus.test.Model.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.asus.test.Model.Entities.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM Item")
    LiveData<List<Item>> getItems();

}
