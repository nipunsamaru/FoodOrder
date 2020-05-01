package com.research.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SignInSelector extends AppCompatActivity {

    private ImageButton sbtn,bbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_selector);

        sbtn=(ImageButton)findViewById(R.id.sellerBtn);
        bbtn=(ImageButton)findViewById(R.id.buyerBtn);

        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUpPage.class);
                startActivity(intent);
            }
        });
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUpSeller.class);
                startActivity(intent);
            }
        });
    }
}
