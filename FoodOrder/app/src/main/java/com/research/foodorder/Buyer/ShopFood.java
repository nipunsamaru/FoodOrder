package com.research.foodorder.Buyer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.research.foodorder.Models.Food;
import com.research.foodorder.R;
import com.research.foodorder.recycler.RecycleFoodList;

import java.util.ArrayList;
import java.util.List;

public class ShopFood extends AppCompatActivity {

    private final List<Food> itemList = new ArrayList<>();
    private DatabaseReference tbl_food;
    private RecycleFoodList madpter;
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;
    private String shopid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_food);

        recyclerView = (RecyclerView)findViewById(R.id.foodlist);

        Intent intent = getIntent();
         shopid = intent.getStringExtra("shopid");


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        tbl_food = database.getReference("Food");



        tbl_food.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

               Food fd=dataSnapshot.getValue(Food.class);
             if(fd.getShopId().equalsIgnoreCase(shopid))
              {
                  Log.i("ccccccc",fd.getCategory());


                  itemList.add(new Food(fd.getShopId(),fd.getName(), fd.getCategory(), fd.getPrice(), fd.getQty(), fd.getUrl()));
                  madpter = new RecycleFoodList(itemList,getApplicationContext());
                  RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
                  mLayoutManager.setAutoMeasureEnabled(true);
                  recyclerView.setLayoutManager(mLayoutManager);
                  recyclerView.setItemAnimator(new DefaultItemAnimator());
                  recyclerView.setAdapter(madpter);
              }
                //Log.i("dddddddd",shopid);

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

    }






}
