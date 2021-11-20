package com.example.girlfriend_renting_service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("Sumit19jan/7fda9476a2b4cbef155ca956df276562/raw/558e27c3fb194b3e2304bc6d4169bbf4610c24e3/gistfile1.txt")
    Call<ResponseDTO> getProfile();
}
