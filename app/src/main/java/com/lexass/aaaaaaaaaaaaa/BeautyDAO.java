package com.lexass.aaaaaaaaaaaaa;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BeautyDAO {
    // @Insert
    //  void addPizza(PizzaDTO pizza);

    //  @Delete
    // void deletePizza(PizzaDTO pizza);

    //@Query("SELECT * FROM pizza")
    // LiveData<List<PizzaDTO>> getAllPizzas();

    @Insert
    void AddBeauty(Beauty beauty);

    @Update
    void UpdateBeauty(Beauty beauty);

    @Delete
    void DeleteBeauty(Beauty beauty);

    @Query("SELECT * FROM beauty")
    LiveData<List<Beauty>> getAllBeautis();

    @Query("select * from beauty where name ==:name ")
    public Beauty getBeauty(String name);

    @Query("select * from beauty")
    public LiveData<List<Beauty>> getAllBeautisLive();
}
