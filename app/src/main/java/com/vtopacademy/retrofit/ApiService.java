package com.vtopacademy.retrofit;

import com.vtopacademy.schools.SchoolResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/** Retrofit interface for making api calls. */
public interface ApiService {

    /** Returns all schools. */
    @GET("schools")
    Call<List<SchoolResponse>> getAllSchools();

}
