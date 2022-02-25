package com.example.encardv1.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.encardv1.db.model.WordsModel;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(WordsModel model);

    @Query("SELECT * FROM wordsmodel WHERE category =:userCategory")
    LiveData<List<WordsModel>> getAll(String userCategory);
}
