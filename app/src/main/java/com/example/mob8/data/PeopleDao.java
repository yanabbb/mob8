package com.example.mob8.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mob8.data.model.PeopleEntity;

import java.util.List;

@Dao
public interface PeopleDao {
    @Query("SELECT * FROM PeopleEntity")
    LiveData<List<PeopleEntity>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PeopleEntity entity);
}
