package com.example.girlfriend_renting_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity {
    TextView mTvFullName,mTvEmailAddress,mTvAge,mTvAadharNumber;
    DatabaseReference rootDataBaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mTvFullName = findViewById(R.id.tvProfileName);
        mTvEmailAddress = findViewById(R.id.tvProfileEmailAddress);
        mTvAge = findViewById(R.id.tvProfileAge);
        mTvAadharNumber = findViewById(R.id.tvProfileAadharNumber);
        rootDataBaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        rootDataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                   String fullName = snapshot.child("users").child("name").getValue(String.class);
                    String emailAddress = snapshot.child("users").child("email").getValue(String.class);
                    String age = snapshot.child("users").child("age").getValue(String.class);
                    String aadharNumber = snapshot.child("users").child("adhar").getValue(String.class);
                     mTvFullName.setText("Sumit Rai");
                     mTvEmailAddress.setText("raisumit540@gmail.com");
                     mTvAge.setText("24");
                     mTvAadharNumber.setText("945953817966");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}