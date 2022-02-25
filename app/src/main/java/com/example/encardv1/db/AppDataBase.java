package com.example.encardv1.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.encardv1.db.dao.CategoryDao;
import com.example.encardv1.db.dao.WordDao;
import com.example.encardv1.db.model.CategoryModel;
import com.example.encardv1.db.model.WordsModel;

@Database(entities = {CategoryModel.class , WordsModel.class}, version = 2)
public abstract class  AppDataBase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract WordDao wordDao();
}
