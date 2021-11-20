package com.example.girlfriend_renting_service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("Sumit19jan/7fda9476a2b4cbef155ca956df276562/raw/ab480d2c149df9e73bd091fafbf6ee7d36b24abf/gistfile1.txt")
    Call<ResponseDTO> getProfile();
}
