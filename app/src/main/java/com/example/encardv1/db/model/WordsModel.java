package com.example.encardv1.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordsModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String word;
    public String category;

    public WordsModel(int id, String word, String category) {
        this.id = id;
        this.word = word;
        this.category = category;
    }
}
