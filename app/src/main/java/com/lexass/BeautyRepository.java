package com.lexass;

import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lexass.Model.Beauty;
import com.lexass.Model.POJO.PaginatedBeautiesPOJO;
import com.lexass.BuildConfig;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeautyRepository {

    private RAWGapi api;
    private Retrofit retrofit;
    private static BeautyRepository mInstance;

    MutableLiveData<List<Beauty>> list = new MutableLiveData<>();
    private Gson gson = new GsonBuilder().create();

    public BeautyRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rawg.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(RAWGapi.class);
    }


    public LiveData<List<Beauty>> getAllBeauties(){
        MutableLiveData<List<Beauty>> result = new MutableLiveData<>();

        api.getListOfBeauties(BuildConfig.RAWG_API_KEY).enqueue(new Callback<PaginatedBeautiesPOJO>() {
            @Override
            public void onResponse(Call<PaginatedBeautiesPOJO> call, Response<PaginatedBeautiesPOJO> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            result.setValue(response.body().getResults().stream().map(pojo -> new Beauty(pojo.getId(),
                                    pojo.getName(), pojo.getBackground_img())).collect(Collectors.toList()));
                        }
                    }
                }else {
                    if (response.errorBody() != null) {
                        try {
                            Log.d("AAAAAAAAAAAAAAAAAAAAAAA", response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<PaginatedBeautiesPOJO> call, Throwable t) {
                Log.d("Successful", "NO");
            }
        });
        return result;
    }

    public static BeautyRepository getInstance(){
        if (mInstance == null){
            mInstance = new BeautyRepository();
        }
        return mInstance;
    }
}
