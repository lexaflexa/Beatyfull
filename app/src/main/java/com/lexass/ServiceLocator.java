package com.lexass;

import android.content.Context;

import com.lexass.Database.AppRepository;


public class ServiceLocator {
    private static ServiceLocator serviceLocator;

    private AppRepository mRepository;

    private Context context;

    private ServiceLocator(Context context){
        serviceLocator = this;

        mRepository = new AppRepository(context);
    }

    public static ServiceLocator getInstance(){
        return serviceLocator;
    }

    public static void init (Context context){
        serviceLocator = new ServiceLocator(context);
    }

    public AppRepository getRepository(){
        return mRepository;
    }
}
