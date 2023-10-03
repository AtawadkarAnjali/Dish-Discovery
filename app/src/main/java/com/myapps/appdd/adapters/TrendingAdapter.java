package com.myapps.appdd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myapps.appdd.R;
import com.myapps.appdd.models.TrendingModel;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    private Context context;
    private List<TrendingModel> trendingModelList;

    public TrendingAdapter(Context context, List<TrendingModel> trendingModelList ) {
        this.context = context;
        this.trendingModelList = trendingModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_recipes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(trendingModelList.get(position).getImg_url()).into(holder.trendImg);
        holder.name.setText(trendingModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return trendingModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView trendImg;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            trendImg = itemView.findViewById(R.id.trend_img);
            name = itemView.findViewById(R.id.trend_name);
        }
    }
}
