package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileDetailsActivity extends AppCompatActivity {

    private ImageView mIvImage;
    private ImageView mIvImage1;
    private ImageView mIvImage2;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvColor;
    private Button mBtnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details2);
        mIvImage = findViewById(R.id.ivImage);
        mIvImage1 = findViewById(R.id.ivImage1);
        mIvImage2 = findViewById(R.id.ivImage2);
        mTvName = findViewById(R.id.name);
        mTvAge = findViewById(R.id.age);
        mTvColor = findViewById(R.id.color);
        mBtnProceed = findViewById(R.id.btnProceed);

        Intent intent = getIntent();
        Glide.with(mIvImage).load(intent.getStringExtra("imageUrl")).into(mIvImage);
        Glide.with(mIvImage1).load(intent.getStringExtra("imageUrl")).into(mIvImage1);
        Glide.with(mIvImage2).load(intent.getStringExtra("imageUrl")).into(mIvImage2);
        mTvName.setText(intent.getStringExtra("name"));
        mTvAge.setText(intent.getStringExtra("age"));
        mTvColor.setText(intent.getStringExtra("color"));
    }
}