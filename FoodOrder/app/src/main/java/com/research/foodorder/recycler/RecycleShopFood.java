package com.research.foodorder.recycler;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.research.foodorder.Models.Food;
import com.research.foodorder.R;
import com.research.foodorder.utils.CircleGlide;

import java.util.List;

public class RecycleShopFood  extends RecyclerView.Adapter<RecycleShopFood.FoodViewHolder>   {


    private List<Food> items;
    private Context context;


    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        public TextView foodname, price,qty;
        public ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {

            super(itemView);
            foodname=(TextView)itemView.findViewById(R.id.sfdfoodname);
            price=(TextView)itemView.findViewById(R.id.sfdfoodpric);
            qty=(TextView)itemView.findViewById(R.id.sfdfoodqty);
            imageView=(ImageView)itemView.findViewById(R.id.sfd_image);
        }



    }

    public RecycleShopFood(List<Food>food,Context context) {
        this.items=food;
        this.context=context;
    }



    @NonNull
    @Override
    public RecycleShopFood.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopfooditem,parent,false);
        return new RecycleShopFood.FoodViewHolder(foodview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleShopFood.FoodViewHolder holder, int position) {

        Food fd= items.get(position);

        holder.foodname.setText(fd.getName());
        holder.qty.setText(String.valueOf(fd.getQty()));
        holder.price.setText(fd.getPrice().toString());
        Glide.with(context).load(Uri.parse(fd.getUrl())).transform(new CircleGlide(context)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
