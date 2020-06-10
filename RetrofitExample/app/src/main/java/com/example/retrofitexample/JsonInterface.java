package com.example.retrofitexample;

import android.graphics.PostProcessor;

import java.lang.ref.PhantomReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface JsonInterface {

    @GET("employees")
    Call<Profile> getEmployees();

    @GET("employee/{num}")
    Call<Profile> getIndividualProfile(@Path("num") int num);

    @POST("create")
    Call<Profile> addProf(@Body Profile profile);

    @DELETE("delete/{id}")
    Call<Void> deletePost(@Path("id") int id);


}
