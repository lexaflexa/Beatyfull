package com.lexass.Database;


import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.lexass.Model.Employee;
import com.lexass.Model.Records;
import com.lexass.Model.Spaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Employee.class, Spaces.class, Records.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract BeautyDao employeeDao();
    public abstract SpacesDao spacesDao();


    Employee[] employees = {
            new Employee("НОГТИ РУКИ", 1222),
            new Employee("НОГТИ НОГИ", 3324),
            new Employee("ТОТАЛЬНАЯ ДЕПИЛЯЦИЯ", 1500)
    };

    Spaces[] spaces = {
            new Spaces("РУКИ НОГТИ", "НОГТИ РУКИ", 1000),
            new Spaces("НОГИ НОГТИ", "НОГТИ НОГИ", 1500)
    };



    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "datebayo")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("DataValue", "preInitData");

                                    AppDatabase.databaseWriteExecutor.execute(() -> {
                                        INSTANCE.employeeDao().insertAll(INSTANCE.employees);
                                        INSTANCE.spacesDao().insertAll(INSTANCE.spaces);

                                        Log.d("DataValue", "initData");
                                    });


                                }
                            })
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}