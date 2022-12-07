package com.lexass.ViewModels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lexass.BeautyRepository;
import com.lexass.Model.Beauty;

import java.util.List;


public class APIViewModel extends ViewModel {
    private BeautyRepository mRepository;

    public LiveData<List<Beauty>> getAllBeauties(){
        return BeautyRepository.getInstance().getAllBeauties();
    }
}
