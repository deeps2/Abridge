package com.example.abridge.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abridge.R;
import com.example.abridge.model.Issues;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IssuesAdapter extends RecyclerView.Adapter<IssuesAdapter.IssuesViewHolder> {

    private List<Issues> issuesList;

    public IssuesAdapter(List<Issues> issuesList) {
        this.issuesList = issuesList;
    }

    public static class IssuesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.issue_title)
        TextView issueTitle;

        @BindView(R.id.issue_number)
        TextView issueNumber;

        @BindView(R.id.issue_creator_name)
        TextView issueCreatorName;

        public IssuesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Issues issue) {
            issueTitle.setText(issue.getTitle());
            issueNumber.setText(issue.getIssueID());
            issueCreatorName.setText(issue.getUser().getUserName());
        }
    }

    @NonNull
    @Override
    public IssuesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IssuesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.issues_list_item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull IssuesViewHolder holderCom, int position) {
        holderCom.setData(issuesList.get(position));
    }

    @Override
    public int getItemCount() {
        return (issuesList == null) ? 0 : issuesList.size();
    }
}
