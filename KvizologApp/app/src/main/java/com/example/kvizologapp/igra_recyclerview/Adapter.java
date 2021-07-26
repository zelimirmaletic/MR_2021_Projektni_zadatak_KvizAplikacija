package com.example.kvizologapp.igra_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kvizologapp.R;
import com.example.kvizologapp.data.model.Igra;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<com.example.kvizologapp.igra_recyclerview.Adapter.ViewHolder>{
    private List<Igra> items;

    public interface OnItemClickListener {
        void onItemClick(Igra item);
    }
    private com.example.kvizologapp.igra_recyclerview.Adapter.OnItemClickListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvPoints;
        public TextView tvDate;
        public ImageView ivImage;
        public View layout;
        public TextView tvCounter;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvTitle = v.findViewById(R.id.tv_title);
            tvPoints = v.findViewById(R.id.tv_points);
            tvDate = v.findViewById(R.id.tv_date);
            ivImage = v.findViewById(R.id.iv_image);
            tvCounter = v.findViewById(R.id.tv_counter);
        }
    }

    public Adapter(List<Igra> items, com.example.kvizologapp.igra_recyclerview.Adapter.OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public com.example.kvizologapp.igra_recyclerview.Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // creating a new view-a
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.igra_card, parent, false);
        com.example.kvizologapp.igra_recyclerview.Adapter.ViewHolder vh = new com.example.kvizologapp.igra_recyclerview.Adapter.ViewHolder(v);
        return vh;
    }


    // setting content inside view-a (invoked by the layout manager)
    @Override
    public void onBindViewHolder(com.example.kvizologapp.igra_recyclerview.Adapter.ViewHolder holder, final int position) {
        final Igra item = items.get(position);
        //Set colors of first three cards
        if(position == 0)
            holder.ivImage.setImageResource(R.drawable.ic_baseline_videogame_yellow_asset_24);
        else if(position==1)
            holder.ivImage.setImageResource(R.drawable.ic_baseline_videogame_silver_asset_24);
        else if(position == 2)
            holder.ivImage.setImageResource(R.drawable.ic_baseline_videogame_bronze_asset_24);
        //Set views
        holder.tvTitle.setText(item.getEmail());
        holder.tvPoints.setText(Integer.toString(item.getPoints()));
        holder.tvCounter.setText(Integer.toString(position+1)+". ");

        long dateLong = item.getDate();
        Date date = new Date(dateLong);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        holder.tvDate.setText(dateFormat.format(date));

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
