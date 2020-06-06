package com.example.abridge.view;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abridge.R;
import com.example.abridge.model.Issues;
import com.example.abridge.presenter.IssuesContract;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IssuesContract.View {

    @BindView(R.id.issues_recycler)
    RecyclerView issuesRecycler;

    IssuesContract.Presenter mPresenter;

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //findViewById()

        tvText = findViewById(R.id.first_text);
//        mPresenter = new IssuesPresenter(this);
//
//        mPresenter.fetchIssuesList("square", "retrofit");
//
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);

//        Thread thread = new Thread();
//        thread.run();


        //viewModelNormal();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModelApplication();
            }
        }, 5000);

    }

//    class TestThread extends Thread {
//        @Override
//        public void run() {
//            super.run();
//            updateThread("completed");
//        }
//    }
//
//    private void updateThread(String str) {
//
//    }

    @Override
    public void displayErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayIssuesList(List<Issues> issuesList) {
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        IssuesAdapter adapter = new IssuesAdapter(issuesList);
        issuesRecycler.setLayoutManager(new LinearLayoutManager(this));
        issuesRecycler.setAdapter(adapter);
        issuesRecycler.addItemDecoration(itemDecor);
    }

    public void viewModelNormal() {
        //1 (Constructor should be empty)
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        //2
        myViewModel = new ViewModelProvider(this, new Factory(1, 2)).get(MyViewModel.class);

        //3
        final int x = 10, y = 20;
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyViewModel(x, y); //Unchecked cast warning. to solve that use Objects.requireNonNull(modelClass.cast(new MyViewModel(x, y)));
            }
        }).get(MyViewModel.class);

        //4 (DON't use this one)
        //MyViewModel myViewModel = new ViewModelProvider.NewInstanceFactory().create(MyViewModel.class);
    }

    public static class MyViewModel extends ViewModel {
        int x, y;

        public MyViewModel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Factory implements ViewModelProvider.Factory {
        int x;
        int y;

        public Factory(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return Objects.requireNonNull(modelClass.cast(new MyViewModel(1, 2)));
        }
    }

    public void viewModelApplication() {
        //11
        int x = 0;
        x = 1;

        //MyAndroidViewModel myAndroidViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MyAndroidViewModel.class);
        //myAndroidViewModel.x = 10;
        //myAndroidViewModel.y = 20;

        //MyAndroidViewModel myAndroidViewModel2 = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MyAndroidViewModel.class);
        //myAndroidViewModel2.x = 10;
        //myAndroidViewModel2.y = 20;

        MyAndroidViewModel myAndroidViewModel3 = new ViewModelProvider(this).get(MyAndroidViewModel.class);
        //myAndroidViewModel3.x = 2;
        //myAndroidViewModel3.y = 3;
    }

    public static class MyAndroidViewModel extends AndroidViewModel {
//        int x;
//        int y;
//
//        public MyAndroidViewModel(@NonNull Application application) {
//            super(application);
//            x = 1;
//            y = 2;
//        }


        public MyAndroidViewModel(@NonNull Application application) {
            super(application);
        }

        @NonNull
        @Override
        public <T extends Application> T getApplication() {
            return super.getApplication();
        }
    }

}
