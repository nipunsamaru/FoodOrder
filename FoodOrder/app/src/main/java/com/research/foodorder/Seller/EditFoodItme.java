package com.research.foodorder.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.research.foodorder.R;

public class EditFoodItme extends AppCompatActivity {

    private TextView Name;
    private ImageView image;
    private EditText price,qty;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_itme);

        Name=findViewById(R.id.fdname);
        image=findViewById(R.id.imageViewfd);
        price=findViewById(R.id.fdprice);
        qty=findViewById(R.id.fdqty);
        update=findViewById(R.id.fdup);




    }
}
