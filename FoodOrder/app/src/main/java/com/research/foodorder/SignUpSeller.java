package com.research.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.research.foodorder.Models.User;

public class SignUpSeller extends AppCompatActivity {

    private EditText sname,sphone,saddress,shopName,spass;
    private Button submits;
    private DatabaseReference tbl_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller);

        sname=(EditText) findViewById(R.id.signup_sid);
        sphone=(EditText) findViewById(R.id.smobile);
        saddress=(EditText) findViewById(R.id.saddress);
        shopName=(EditText) findViewById(R.id.ssname);
        spass=(EditText) findViewById(R.id.signup_spassword);
        submits=(Button) findViewById(R.id.add_saccount);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        tbl_user = database.getReference("User");

        submits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mydialog=new ProgressDialog(SignUpSeller.this);
                mydialog.setMessage("Please waiting...");
                mydialog.show();

                tbl_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(sphone.getText().toString()).exists()){
                            mydialog.dismiss();
                            Toast.makeText(SignUpSeller.this,"Phone Number already register",Toast.LENGTH_LONG);
                        }
                        else{
                            mydialog.dismiss();
                            User fuser=new User(sname.getText().toString(), spass.getText().toString(),true,saddress.getText().toString(),shopName.getText().toString());
                            tbl_user.child(sphone.getText().toString()).setValue(fuser);
                            finish();
                            Toast.makeText(SignUpSeller.this,"Success..",Toast.LENGTH_LONG);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });



    }
}
