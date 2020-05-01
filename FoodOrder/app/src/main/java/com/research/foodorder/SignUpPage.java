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

public class SignUpPage extends AppCompatActivity {

    EditText signupName, signupPassword,bpno,sbcpass;
    Button addAccount;
    private DatabaseReference tbl_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        signupName = (EditText) findViewById(R.id.signup_id);
        bpno=(EditText)findViewById(R.id.mobile);
        signupPassword = (EditText) findViewById(R.id.signup_bpassword);
        sbcpass = (EditText) findViewById(R.id.signup_bpassword);
        addAccount = (Button) findViewById(R.id.add_account);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        tbl_user = database.getReference("User");

        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mydialog = new ProgressDialog(SignUpPage.this);
                mydialog.setMessage("Please waiting...");
                mydialog.show();

                tbl_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(bpno.getText().toString()).exists()){
                            mydialog.dismiss();
                            Toast.makeText(SignUpPage.this,"Phone Number already register",Toast.LENGTH_LONG);
                        }
                        else{
                            mydialog.dismiss();
                            User fuser=new User(signupName.getText().toString(), signupPassword.getText().toString(),false,"","");
                            tbl_user.child(bpno.getText().toString()).setValue(fuser);
                            finish();
                            Toast.makeText(SignUpPage.this,"Success..",Toast.LENGTH_LONG);
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
