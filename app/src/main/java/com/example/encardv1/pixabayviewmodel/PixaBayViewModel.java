package com.example.encardv1.pixabayviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.encardv1.db.model.CategoryModel;
import com.example.encardv1.db.model.WordsModel;
import com.example.encardv1.util.RoomHelper;
import com.example.encardv1.util.SharedPreferencesInj;
import com.example.encardv1.network.model.Hits;
import com.example.encardv1.repository.PixaBayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PixaBayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> mutableLiveData = new MutableLiveData<>();
    public LiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();
    public LiveData<List<WordsModel>> wordsList = new MutableLiveData<>();
    PixaBayRepository repository;
    SharedPreferencesInj sharedPreferencesInj;
    RoomHelper roomHelper;

    @Inject
    public PixaBayViewModel(PixaBayRepository repository , SharedPreferencesInj sharedPreferencesInj , RoomHelper roomHelper) {
        this.repository = repository;
        this.sharedPreferencesInj = sharedPreferencesInj;
        this.roomHelper = roomHelper;
    }
    public MutableLiveData<List<Hits>> getImages(String word){
        mutableLiveData = repository.getImages(word);
        return mutableLiveData;
    }

    public boolean getBoolean(){
        return sharedPreferencesInj.getBoolen();
    }

    public void setBoolean(boolean isShow){
        sharedPreferencesInj.setBoolean(isShow);
    }

    public void insertCategory(CategoryModel categoryModel){
        roomHelper.insertCategory(categoryModel);
    }

    public LiveData<List<CategoryModel>> getCategory(){
            return categoryList = roomHelper.getAll();
    }

    public void insertWords(WordsModel wordsModel){
        roomHelper.insertWords(wordsModel);
    }

    public LiveData<List<WordsModel>> getWords(String category){
        return wordsList = roomHelper.getAllWords(category);
    }




}
