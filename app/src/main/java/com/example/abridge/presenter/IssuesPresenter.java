package com.example.abridge.presenter;

import com.example.abridge.model.Issues;
import com.example.abridge.repository.IssuesRepository;

import java.util.List;

public class IssuesPresenter implements IssuesContract.Presenter, IssuesRepository.APIResponseHandler {

    IssuesContract.View mView;
    IssuesRepository mRepo;

    public IssuesPresenter(IssuesContract.View mView) {
        this.mView = mView;
        mRepo = new IssuesRepository(this);
    }

    @Override
    public void fetchIssuesList(String repoOwner, String repoName) {
        mRepo.fetchData(repoOwner, repoName);
    }

    @Override
    public void onAPIError() {
        mView.displayErrorMessage("Oops! an error occurred");
    }

    @Override
    public void onIssuesListFetched(List<Issues> issuesList) {
        if (issuesList == null || issuesList.isEmpty()) {
            mView.displayErrorMessage("No issues found");
            return;
        }

        //todo -- convert time to readable time

        mView.displayIssuesList(issuesList);
    }


}
