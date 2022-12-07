package com.lexass.Database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.lexass.Model.Employee;

import java.util.List;


public class AppRepository {
    private BeautyDao beautyDao;
    private LiveData<List<Employee>> allEmployee;
    private Context context;


    public AppRepository(Context context){//Application application
        this.context = context;
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        beautyDao = appDatabase.employeeDao();
        allEmployee = beautyDao.getAll();
    }

    public LiveData<List<Employee>> getAllEmployee(){return allEmployee;}

}
