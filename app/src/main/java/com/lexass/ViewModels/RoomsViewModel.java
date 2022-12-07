package com.lexass.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lexass.Database.AppRepository;
import com.lexass.Model.Employee;
import com.lexass.ServiceLocator;

import java.util.List;

public class RoomsViewModel extends AndroidViewModel {

    private AppRepository mRepository;
    private LiveData<List<Employee>> mEmployees;

    public RoomsViewModel(@NonNull Application application) {
        super(application);

        mRepository = ServiceLocator.getInstance().getRepository();
        mEmployees = mRepository.getAllEmployee();
    }

    public LiveData<List<Employee>> getEmployees(){
        return mEmployees;
    }
}
