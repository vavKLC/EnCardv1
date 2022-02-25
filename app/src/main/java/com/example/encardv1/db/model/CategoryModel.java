package com.example.encardv1.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    String name;

    public CategoryModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
