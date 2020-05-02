package com.research.foodorder.Buyer.ui.shop;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.research.foodorder.Models.Food;
import com.research.foodorder.Models.Shop;
import com.research.foodorder.R;
import com.research.foodorder.utils.CircleGlide;

import java.util.List;

public class HomeViewModel extends RecyclerView.Adapter<HomeViewModel.MyViewHolder> {

    private List<Shop> items;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView shopname, location,shopid;
        public RatingBar ratingBar;
        public ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shopid=(TextView)itemView.findViewById(R.id.shop_id);
            shopname=(TextView)itemView.findViewById(R.id.shop_name);
            location=(TextView)itemView.findViewById(R.id.shop_locate);
            ratingBar=(RatingBar)itemView.findViewById(R.id.ratingBar);
            imageView=(ImageView)itemView.findViewById(R.id.shop_image);

        }
    }


    public HomeViewModel(List<Shop>shops,Context context) {
        this.items=shops;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeViewModel.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shops,parent,false);
        return new MyViewHolder(foodview);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewModel.MyViewHolder holder, int position) {

        Shop sp= items.get(position);
        holder.shopid.setText(sp.getShopId());
        holder.shopname.setText(sp.getName());
        holder.location.setText(sp.getLocation());
        holder.ratingBar.setRating(sp.getRating());
        Glide.with(context).load(Uri.parse(sp.getImage())).transform(new CircleGlide(context)).into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return items.size();
    }


}