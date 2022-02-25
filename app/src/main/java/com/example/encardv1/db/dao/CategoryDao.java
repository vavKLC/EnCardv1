package com.example.encardv1.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.encardv1.db.model.CategoryModel;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insert(CategoryModel categoryModel);

    @Query("SELECT * FROM categorymodel")
    LiveData<List<CategoryModel>> getAll();
}
