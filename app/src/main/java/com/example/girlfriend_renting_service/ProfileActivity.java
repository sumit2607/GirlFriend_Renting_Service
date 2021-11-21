package com.example.girlfriend_renting_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity {
    TextView mTvFullName,mTvEmailAddress,mTvAge,mTvAadharNumber,mTvTestName;
    Button mBtnContact;
    DatabaseReference rootDataBaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mTvFullName = findViewById(R.id.tvProfileName);
        mTvEmailAddress = findViewById(R.id.tvProfileEmailAddress);
        mTvTestName = findViewById(R.id.testTvName);
        mTvAge = findViewById(R.id.tvProfileAge);
        mBtnContact = findViewById(R.id.testBtnContact);
        final String num = "+917415126102";
        final String text = "Hello";

        mBtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled();
                if (installed) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+ text));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ProfileActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isAppInstalled() {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;
        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            is_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }

}