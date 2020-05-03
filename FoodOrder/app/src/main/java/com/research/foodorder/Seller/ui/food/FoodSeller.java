package com.research.foodorder.Seller.ui.food;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.research.foodorder.Buyer.ShopFood;
import com.research.foodorder.Buyer.ui.shop.HomeViewModel;
import com.research.foodorder.Models.Food;
import com.research.foodorder.Models.Shop;
import com.research.foodorder.R;
import com.research.foodorder.Seller.EditFoodItme;
import com.research.foodorder.recycler.RecycleFoodList;
import com.research.foodorder.recycler.RecycleShopFood;
import com.research.foodorder.recycler.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;


public class FoodSeller extends Fragment {

//    public FoodSeller(){
//        setHasOptionsMenu(true);
//    }
//
//    public void onCreate(Bundle a){
//        super.onCreate(a);
//        setHasOptionsMenu(true);
//    }
private final List<Food> itemList = new ArrayList<>();

    private DatabaseReference tbl_food;
    private RecycleShopFood madpter;
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private String shopid;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_food_seller, container, false);

     //   Bundle bundle = this.getArguments();
//        shopid = getArguments().getString("shopID").toString();

        recyclerView = (RecyclerView) root.findViewById(R.id.sfddlist);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        tbl_food = database.getReference("Food");


        tbl_food.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Food fd=dataSnapshot.getValue(Food.class);

//                if(fd.getShopId().equalsIgnoreCase(shopid))
//                {
                    Log.i("ccccccc",fd.getCategory());


                    itemList.add(new Food(fd.getShopId(),fd.getName(), fd.getCategory(), fd.getPrice(), fd.getQty(), fd.getUrl()));
                    madpter = new RecycleShopFood(itemList,getContext());
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                    mLayoutManager.setAutoMeasureEnabled(true);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(madpter);
             //   }
//                Log.i("dddddddd",shopid);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        appCompatActivity = (AppCompatActivity) getActivity();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                //     TextView id = view.findViewById(R.id.shop_id);

                // Log.i("ffff",id.getText().toString());

                  Intent intent =new Intent(getContext(), EditFoodItme.class);
               //   intent.putExtra("shopid", id.getText());
                  startActivity(intent);

                //Detail.navigate(appCompatActivity, view.findViewById(R.id.iv_recipe));

            }

            @Override
            public void onLongClick(View view, int position) {

            }



        }));

        return root;
    }
}
