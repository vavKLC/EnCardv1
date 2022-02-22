package com.example.encardv1.pixabayviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.encardv1.util.SharedPreferencesInj;
import com.example.encardv1.network.model.Hits;
import com.example.encardv1.repository.PixaBayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PixaBayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> mutableLiveData = new MutableLiveData<>();
    PixaBayRepository repository;
    SharedPreferencesInj sharedPreferencesInj;


    @Inject
    public PixaBayViewModel(PixaBayRepository repository , SharedPreferencesInj sharedPreferencesInj) {
        this.repository = repository;
        this.sharedPreferencesInj = sharedPreferencesInj;
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



}
