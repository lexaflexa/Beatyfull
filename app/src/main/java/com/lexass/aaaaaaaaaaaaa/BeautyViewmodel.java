package com.lexass.aaaaaaaaaaaaa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BeautyViewmodel extends AndroidViewModel {
    private BeautyRepozitory repozitory;
    private LiveData<List<Beauty>> beautyList;
    public BeautyViewmodel(@NonNull Application application) {
        super(application);
        repozitory = new BeautyRepozitory(application);
        beautyList = repozitory.getAllBeautis();
    }
    public void insert(Beauty beauty){ repozitory.insert(beauty); }
    public void update(Beauty beauty){
        repozitory.update(beauty);
    }
    public void delete(Beauty beauty){
        repozitory.delete(beauty);
    }
    public LiveData<List<Beauty>> getAllBeautis(){
        return beautyList;
    }
}