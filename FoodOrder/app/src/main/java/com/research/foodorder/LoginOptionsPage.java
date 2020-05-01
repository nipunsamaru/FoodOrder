package com.research.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginOptionsPage extends AppCompatActivity {

    Button sign_in,sign_up;
    Button details,orderdetails;
    LinearLayout l1,l2;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options_page);

        //Set References to Layout Components
        sign_in =(Button)findViewById(R.id.signin);
        sign_up =(Button) findViewById(R.id.signup);

        details = (Button) findViewById(R.id.userinfo);
        orderdetails = (Button) findViewById(R.id.order_details);

        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);

        //Set Animation
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

//        l1.setAnimation(uptodown);
//        l2.setAnimation(downtoup);


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinpage = new Intent(getApplicationContext(),SignInPage.class);
                startActivity(signinpage);
             //   finish();

            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(getApplicationContext(),SignInSelector.class);
                startActivity(signuppage);
            //    finish();

            }
        });

    }



}
