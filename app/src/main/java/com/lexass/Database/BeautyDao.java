package com.lexass.Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.lexass.Model.Employee;

import java.util.List;


@Dao
public interface BeautyDao {

    @Query("SELECT * FROM employee")
    LiveData<List<Employee>> getAll();

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee employee);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Employee[] employees);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);

}