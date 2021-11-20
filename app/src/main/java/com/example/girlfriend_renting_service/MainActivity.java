package com.example.girlfriend_renting_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.girlfriend_renting_service.adapter.ProfileAdapter;
import com.example.girlfriend_renting_service.pay.PaymentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private List<ProfileDTO> profileDTOS = new ArrayList<>();
    private ProfileAdapter profileAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        BottomNavigation();
        callApi();
    }
    private void callApi() {
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
        profileAdapter = new ProfileAdapter(profileDTOS, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(profileAdapter);
    }
    @Override
    public void onItemClick(ProfileDTO profileDTO) {
        Intent intent = new Intent(MainActivity.this, ProfileDetailsActivity.class);
        intent.putExtra("imageUrl", profileDTO.getProfileImageUrl());
        intent.putExtra("name", profileDTO.getName());
        intent.putExtra("age", profileDTO.getAge());
        intent.putExtra("color", profileDTO.getColor());
        startActivity(intent);
    }
    @SuppressLint("NonConstantResourceId")
    private void BottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (bottomNavigationView.getSelectedItemId()) {
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    return true;
                case R.id.category:
                    startActivity(new Intent(getApplicationContext(), SignUp.class));
                    return true;
                case R.id.payment:
                    startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
                    return true;
                case R.id.profile:
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    return true;
            }
            return false;
        });
    }
}