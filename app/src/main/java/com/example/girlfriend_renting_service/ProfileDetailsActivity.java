package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.girlfriend_renting_service.pay.PaymentActivity;

import java.io.Serializable;

public class ProfileDetailsActivity extends AppCompatActivity {

    private ImageView mIvImage;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvColor;
    private TextView mTvLocation;
    private TextView mTvAbout;
    private TextView mTvType;
    private TextView mTvPhone;
    private Button mBtnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details2);
        mIvImage = findViewById(R.id.ivImage);


        mTvName = findViewById(R.id.name);
        mTvAge = findViewById(R.id.age);
        mTvColor = findViewById(R.id.color);
        mTvPhone = findViewById(R.id.phone);
        mTvLocation = findViewById(R.id.location);
        mTvType = findViewById(R.id.body);
        mTvAbout = findViewById(R.id.about);
        mBtnProceed = findViewById(R.id.btnProceed);
        mBtnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileDetailsActivity.this, Payment.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        Glide.with(mIvImage).load(intent.getStringExtra("imageUrl")).into(mIvImage);
        mTvName.setText(intent.getStringExtra("name"));
        mTvAge.setText(intent.getStringExtra("age"));
        mTvColor.setText(intent.getStringExtra("color"));
        mTvType.setText(intent.getStringExtra("type"));
        mTvLocation.setText(intent.getStringExtra("location"));
        mTvAbout.setText(intent.getStringExtra("about"));
        mTvPhone.setText(intent.getStringExtra("phone"));
    }
}