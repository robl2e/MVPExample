package com.robl2e.mvpexample.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.robl2e.mvpexample.R;
import com.robl2e.mvpexample.data.local.DataRepository;
import com.robl2e.mvpexample.data.model.Data;
import com.robl2e.mvpexample.ui.mvp.AbstractMvpActivity;

public class MainActivity extends AbstractMvpActivity<MainContract.MvpView, MainContract.Presenter>
        implements MainContract.MvpView {

    private Button loadDataButton;
    private ProgressBar progressIndicator;
    private TextView dataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressIndicator = (ProgressBar) findViewById(R.id.progress_indicator);
        dataTextView = (TextView) findViewById(R.id.text_data);
        loadDataButton = (Button) findViewById(R.id.button_load);
        loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataTextView.setVisibility(View.INVISIBLE);
                displayProgressIndicator(true);
                getPresenter().loadData();
            }
        });
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        DataRepository dataRepository = new DataRepository();
        return new MainPresenter(dataRepository);
    }

    @Override
    public void renderData(Data data) {
        dataTextView.setVisibility(View.VISIBLE);
        dataTextView.setText(data.text);
    }

    @Override
    public void displayProgressIndicator(boolean show) {
        progressIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
