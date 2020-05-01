package com.research.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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

public class SignInPage extends AppCompatActivity {

    EditText signinMobile, signinPassword;
    Button signinbtn;
    private DatabaseReference user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        signinMobile = (EditText) findViewById(R.id.signin_id);
        signinPassword = (EditText) findViewById(R.id.signin_password);
        signinbtn = (Button) findViewById(R.id.signinBtn);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
         user = database.getReference("User");

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Log.i("dd",user.toString());
                final ProgressDialog mydialog=new ProgressDialog(SignInPage.this);
                mydialog.setMessage("Please waiting...");
                mydialog.show();
                user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if (dataSnapshot.child(signinMobile.getText().toString()).exists()) {
                            mydialog.dismiss();

                            User fuser = dataSnapshot.child(signinMobile.getText().toString()).getValue(User.class);
                            if (fuser.getPasssword().equals(signinPassword.getText().toString())) {
                                Toast.makeText(SignInPage.this, "Success", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignInPage.this, "Sorry Please Check Your...", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignInPage.this, "Not Exit User", Toast.LENGTH_SHORT).show();
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
