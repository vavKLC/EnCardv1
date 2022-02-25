package com.example.encardv1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encardv1.databinding.ItemCategoryBinding;
import com.example.encardv1.db.dao.CategoryDao;
import com.example.encardv1.db.model.CategoryModel;
import com.example.encardv1.interfaces.OnItemClickListener;
import com.example.encardv1.interfaces.OnItemClickListenerCat;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    List<CategoryModel> list;
    OnItemClickListenerCat listener;

    public CategoryAdapter(List<CategoryModel> list, OnItemClickListenerCat listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;
        public CategoryHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(CategoryModel categoryModel) {
            binding.categoryTv.setText(categoryModel.getName());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClickCat(categoryModel.getName());
                }
            });
        }
    }
}
