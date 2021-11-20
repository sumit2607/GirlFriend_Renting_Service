package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.girlfriend_renting_service.adapter.ProfileAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity implements ItemClickListener{
    TextView mTvSubscription;
    Button mBtnSubscription;
    RecyclerView mRvSubscription;
    private List<ProfileDTO> profileDTOS = new ArrayList<>();
    private ProfileAdapter profileAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTvSubscription = findViewById(R.id.tvSubscription);
        mBtnSubscription = findViewById(R.id.btnSubscription);
        mRvSubscription = findViewById(R.id.recyclerViewSubscription);
        mBtnSubscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAPI();
            }
        });
    }

    private void callAPI() {
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getProfile().enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                profileDTOS = response.body().getProfile();
                setRecyler();
            }
            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
            }
        });
    }
    private void setRecyler() {
        profileAdapter = new ProfileAdapter(profileDTOS,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvSubscription.setLayoutManager(linearLayoutManager);
        mRvSubscription.setAdapter(profileAdapter);
    }

    @Override
    public void onItemClick(ProfileDTO profileDTO) {
        Intent intent = new Intent(TestActivity.this, ProfileDetailsActivity.class);
        intent.putExtra("imageUrl", profileDTO.getProfileImageUrl());
        intent.putExtra("name", profileDTO.getName());
        intent.putExtra("age", profileDTO.getAge());
        intent.putExtra("color", profileDTO.getColor());
        startActivity(intent);
    }
}