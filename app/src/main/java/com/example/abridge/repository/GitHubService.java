package com.example.abridge.repository;

import com.example.abridge.model.Issues;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("repos/{owner}/{repoName}/issues")
    Call<List<Issues>> getAllIssues(@Path("owner") String owner, @Path("repoName") String repoName);

}



