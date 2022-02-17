package com.example.encardv1.pixabayviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.encardv1.network.model.Hits;
import com.example.encardv1.repository.PixaBayRepository;

import java.util.List;

public class PixaBayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> mutableLiveData = new MutableLiveData<>();

    PixaBayRepository repository = PixaBayRepository.getInstance();

    public MutableLiveData<List<Hits>> getImages(String word){
        mutableLiveData = repository.getImages(word);
        return mutableLiveData;
    }

}
