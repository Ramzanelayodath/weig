package com.example.weightedexample;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.File;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient mInstance;

    //our app database object
    private static PdaDatabase pdaDatabase;
    public static final String DATABASE_NAME = "pdaStockTake.db";

    private DatabaseClient(Context context) {
        this.context = context;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        pdaDatabase = Room.databaseBuilder(context, PdaDatabase.class, DATABASE_NAME).addMigrations(MIGRATION_1_2)

                      .allowMainThreadQueries().build();
    }

    final Migration MIGRATION_1_2 =
            new Migration(1, 2) {
                @Override
                public void migrate(@NonNull final SupportSQLiteDatabase database) {
                    //  database.execSQL("ALTER TABLE products ADD COLUMN attributeSetId INTEGER default 0 NOT NULL");
                    database.execSQL("ALTER TABLE products ADD COLUMN cwUnitOfMeasure TEXT default ''");
                    database.execSQL("ALTER TABLE products ADD COLUMN unitOfMeasure TEXT default ''");


                }
            };


    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public synchronized PdaDatabase getAppDatabase() {
        return pdaDatabase;
    }

    public  static synchronized void flushDb(boolean close) {
        if(pdaDatabase!=null){
            pdaDatabase.getOpenHelper().getReadableDatabase().query("pragma wal_checkpoint;");
            // Check point writes data to main DB, but does not clean -wal file. Other threads may be writing to wal same time.
            // Hence close DB temporarily
            if(close) {
                pdaDatabase.close();
                pdaDatabase = null;
                mInstance = null;
            }
        }
    }



}
