package com.lexass;


import com.lexass.Model.POJO.PaginatedBeautiesPOJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RAWGapi {
    @GET("games")
    Call<PaginatedBeautiesPOJO> getListOfBeauties(@Query("key") String apiKey);
}
