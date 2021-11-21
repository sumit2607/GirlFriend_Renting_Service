package com.example.girlfriend_renting_service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("Sumit19jan/7fda9476a2b4cbef155ca956df276562/raw/f12f1b54ac51fd9de32bc0ebad28c0eaed3116ea/gistfile1.txt")
    Call<ResponseDTO> getProfile();
}
