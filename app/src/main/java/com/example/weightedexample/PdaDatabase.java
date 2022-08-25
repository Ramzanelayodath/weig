package com.example.weightedexample;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { ProductModel.class, }, version = 2)
public abstract class PdaDatabase extends RoomDatabase {
    public abstract ProductDao productDao();





}
