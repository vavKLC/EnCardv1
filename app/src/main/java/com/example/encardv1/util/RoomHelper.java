package com.example.encardv1.util;

import android.telecom.Call;

import androidx.lifecycle.LiveData;

import com.example.encardv1.App;
import com.example.encardv1.db.AppDataBase;
import com.example.encardv1.db.dao.CategoryDao;
import com.example.encardv1.db.dao.WordDao;
import com.example.encardv1.db.model.CategoryModel;
import com.example.encardv1.db.model.WordsModel;

import java.util.List;

import javax.inject.Inject;

public class RoomHelper {
    AppDataBase appDataBase;
    WordDao wordDao;
    CategoryDao categoryDao;

    @Inject
    public RoomHelper(AppDataBase appDataBase, WordDao wordDao, CategoryDao categoryDao) {
        this.appDataBase = appDataBase;
        this.wordDao = wordDao;
        this.categoryDao = categoryDao;
    }

    public AppDataBase getAppDataBase(){
        return appDataBase;
    }

    public CategoryModel insertCategory(CategoryModel categoryModel){
        categoryDao.insert(categoryModel);
        return categoryModel;
    }

    public LiveData<List<CategoryModel>> getAll(){
        return categoryDao.getAll();
    }

    public WordsModel insertWords(WordsModel wordsModel){
        wordDao.insert(wordsModel);
        return wordsModel;
    }

    public LiveData<List<WordsModel>> getAllWords(String category){
        return wordDao.getAll(category);
    }


}
