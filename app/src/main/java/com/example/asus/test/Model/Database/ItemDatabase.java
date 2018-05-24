package com.example.asus.test.Model.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.asus.test.Model.DAO.ItemDao;
import com.example.asus.test.Model.Entities.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase{

    public abstract ItemDao itemDao();

}
