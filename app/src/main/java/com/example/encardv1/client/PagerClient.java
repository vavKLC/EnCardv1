package com.example.encardv1.client;

import com.example.encardv1.R;
import com.example.encardv1.network.model.ViewPagerModel;

import java.util.ArrayList;

public class PagerClient {
    ArrayList<ViewPagerModel> list = new ArrayList<>();

    public ArrayList<ViewPagerModel> getList() {
        list.add(new ViewPagerModel(R.drawable.img , "Категории" , "Создайте собственные категории для слов "));
        list.add(new ViewPagerModel(R.drawable.img_1 , "Слова" , "Создавайте слова на английском и кликайте на" +
                " карточку чтобы увидеть его перевод и картинку для ассоциации "));
        list.add(new ViewPagerModel(R.drawable.img_2 , "Изучение" , "Свайпайте карточку вправо если вы запомнили,влево если пока ещё не уверены "));
        list.add(new ViewPagerModel(R.drawable.img_3 , "Личный кабинет" , "Следите за своими ачивками и количеством очков опыта"));
        list.add(new ViewPagerModel(R.drawable.img_4 , "Давайте начнем!" , ""));
        return list;
    }
}
