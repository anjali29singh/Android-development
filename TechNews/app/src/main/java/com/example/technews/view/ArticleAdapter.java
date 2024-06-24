package com.example.technews.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technews.R;
import com.example.technews.databinding.NewArticleItemBinding;
import com.example.technews.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private Context context;
    private ArrayList<Article> articlesArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articlesArrayList) {
        this.context = context;
        this.articlesArrayList = articlesArrayList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewArticleItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.new_article_item,parent,false);
        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        Article article = articlesArrayList.get(position);
        if(article.getUrlToImage()!=null && article.getUrlToImage()!="Removed")
            holder.newsListItemBinding.setArticle(article);
    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }


    public  class ArticleViewHolder extends RecyclerView.ViewHolder {

    private NewArticleItemBinding newsListItemBinding;
        public ArticleViewHolder(NewArticleItemBinding binding) {
            super(binding.getRoot());
            this.newsListItemBinding = binding;
        newsListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        }
    }

}
