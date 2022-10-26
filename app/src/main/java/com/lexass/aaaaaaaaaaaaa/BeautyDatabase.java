package com.lexass.aaaaaaaaaaaaa;

import android.content.Context;

import  androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

@Database(entities = {Beauty.class},version = 1, exportSchema = false)
public abstract class BeautyDatabase extends RoomDatabase {
    public static SupportSQLiteStatement databaseWriteExecutor;


    public abstract BeautyDAO beautyDAO();

    public  static  BeautyDatabase INSTANCE;

    public  static  BeautyDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (BeautyDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BeautyDatabase.class, "beauty-database").fallbackToDestructiveMigration().build();

                }
            }
        }
        return INSTANCE;
    }
}