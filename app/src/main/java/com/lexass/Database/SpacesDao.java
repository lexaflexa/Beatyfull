package com.lexass.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lexass.Model.Spaces;

import java.util.List;


@Dao
public interface SpacesDao {
    @Query("SELECT * FROM spaces")
    LiveData<List<Spaces>> getAll();

    @Query("SELECT * FROM spaces WHERE id = :id")
    Spaces getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Spaces spaces);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Spaces[] spaces);

    @Update
    void update(Spaces spaces);

    @Delete
    void delete(Spaces spaces);
}
