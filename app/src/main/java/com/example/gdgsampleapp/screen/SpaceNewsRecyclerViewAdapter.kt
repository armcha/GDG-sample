package com.example.gdgsampleapp.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gdgsampleapp.databinding.NewsItemViewBinding
import com.example.gdgsampleapp.model.SpaceNews

class SpaceNewsRecyclerViewAdapter : RecyclerView.Adapter<SpaceNewsRecyclerViewAdapter.NewsViewHolder>() {

    private val items = mutableListOf<SpaceNews>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemViewBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = items[position]
        val binding = holder.newsItemViewBinding
        Glide.with(binding.newsImageView)
                .load(item.imageUrl)
                .into(binding.newsImageView)
        binding.titleTextView.text = item.title
        binding.descriptionTextView.text = item.summary
    }

    fun submitList(news: List<SpaceNews>) {
        items.clear()
        items.addAll(news)
        notifyItemRangeInserted(0, news.size)
    }

    class NewsViewHolder(val newsItemViewBinding: NewsItemViewBinding) :
            RecyclerView.ViewHolder(newsItemViewBinding.root)
}