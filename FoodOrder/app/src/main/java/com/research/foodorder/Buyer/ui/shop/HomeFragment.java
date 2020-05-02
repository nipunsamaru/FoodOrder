package com.research.foodorder.Buyer.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.research.foodorder.Models.Shop;
import com.research.foodorder.R;
import com.research.foodorder.Buyer.ShopFood;
import com.research.foodorder.recycler.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private final List<Shop> itemList = new ArrayList<>();
    private DatabaseReference tbl_shop;
    private HomeViewModel madpter;
    private AppCompatActivity appCompatActivity;
    private RecyclerView recyclerView;

    public HomeFragment(){
        setHasOptionsMenu(true);
    }

    public void onCreate(Bundle a){
        super.onCreate(a);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = (RecyclerView) root.findViewById(R.id.shopdlist);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        tbl_shop = database.getReference("Shop");


        tbl_shop.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                Shop sp=dataSnapshot.getValue(Shop.class);

             //   Log.i("ddd",dataSnapshot.getKey());

                itemList.add(new Shop(dataSnapshot.getKey(),sp.getName(),sp.getLocation(), sp.getRating(),sp.getImage()));
                madpter = new HomeViewModel(itemList, getActivity());
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
                mLayoutManager.setAutoMeasureEnabled(true);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(madpter);

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

                TextView id = view.findViewById(R.id.shop_id);

               // Log.i("ffff",id.getText().toString());

                Intent intent =new Intent(getContext(),ShopFood.class);
                intent.putExtra("shopid", id.getText());
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