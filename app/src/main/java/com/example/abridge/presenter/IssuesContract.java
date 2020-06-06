package com.example.abridge.presenter;

import com.example.abridge.model.Issues;

import java.util.List;

public class IssuesContract {

    public interface View {
        void displayErrorMessage(String errorMessage);

        void displayIssuesList(List<Issues> issuesList);
    }

    public interface Presenter {
        void fetchIssuesList(String repoOwner, String repoName);
    }
}
