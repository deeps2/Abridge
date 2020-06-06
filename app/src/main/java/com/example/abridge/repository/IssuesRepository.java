package com.example.abridge.repository;

import androidx.annotation.NonNull;

import com.example.abridge.model.Issues;
import com.example.abridge.presenter.IssuesContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssuesRepository {

    APIResponseHandler callback;

    public IssuesRepository(APIResponseHandler callback) {
        this.callback = callback;
    }

    public void fetchData(String repoOwner, String repoName) {
        GitHubService service = RestClient.getInstance().getAPIClient().create(GitHubService.class);
        Call<List<Issues>> call = service.getAllIssues(repoOwner, repoName);
        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(@NonNull Call<List<Issues>> call, @NonNull Response<List<Issues>> response) {
                if (!response.isSuccessful())
                    callback.onAPIError();

                callback.onIssuesListFetched(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<Issues>> call, @NonNull Throwable t) {
                callback.onAPIError();
            }
        });
    }

    public interface APIResponseHandler {
        void onIssuesListFetched(List<Issues> issuesList);
        void onAPIError();
    }

}
