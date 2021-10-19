package com.example.loadgithubprofiles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users/nrupuld/repos")
    Call<List<ResponseDTOItem>> getResponse();

}
