package com.example.kvizologapp.news_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kvizologapp.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<com.example.kvizologapp.news_recyclerview.Adapter.ViewHolder> {
    private List<ItemArticle> items;

    public interface OnItemClickListener {
        void onItemClick(ItemArticle item);
    }
    private com.example.kvizologapp.news_recyclerview.Adapter.OnItemClickListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvDate;
        public ImageView ivImage;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvTitle = v.findViewById(R.id.tv_title);
            tvDescription = v.findViewById(R.id.tv_description);
            tvDate = v.findViewById(R.id.tv_date);
            ivImage = v.findViewById(R.id.iv_image);
        }
    }

    public Adapter(List<ItemArticle> items, com.example.kvizologapp.news_recyclerview.Adapter.OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public com.example.kvizologapp.news_recyclerview.Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // creating a new view-a
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.news_card, parent, false);
        com.example.kvizologapp.news_recyclerview.Adapter.ViewHolder vh = new com.example.kvizologapp.news_recyclerview.Adapter.ViewHolder(v);
        return vh;
    }


    // setting content inside view-a (invoked by the layout manager)
    @Override
    public void onBindViewHolder(com.example.kvizologapp.news_recyclerview.Adapter.ViewHolder holder, final int position) {
        final ItemArticle item = items.get(position);
        //Set views
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.tvDate.setText(item.getDate());

        //TO-DO
        //Check if there is an internet connection
        //If connection is available grab the imege from the internet
        //Otherwise hide image view and do not call Glide library

        //Set image using Glide (if there is a connection to the internet!)
        Glide.with(holder.ivImage.getContext()).load(item.getImage_url()).error(R.drawable.ic_baseline_broken_image_24).into(holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

