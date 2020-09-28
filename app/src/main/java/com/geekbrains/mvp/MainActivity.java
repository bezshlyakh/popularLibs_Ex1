package com.geekbrains.mvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.geekbrains.mvp.presenter.MainPresenter;
import com.geekbrains.mvp.view.MainView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private Button mBtnCounter1;
    private Button mBtnCounter2;
    private Button mBtnCounter3;

    private MainPresenter mPresenter = new MainPresenter(this);
    private HashMap<Integer, Integer> btnsIDs = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnCounter1 = findViewById(R.id.btn_counter1);
        mBtnCounter2 = findViewById(R.id.btn_counter2);
        mBtnCounter3 = findViewById(R.id.btn_counter3);

        btnsIDs.put(R.id.btn_counter1, 1);
        btnsIDs.put(R.id.btn_counter2, 2);
        btnsIDs.put(R.id.btn_counter3, 3);

        mBtnCounter1.setOnClickListener(this);
        mBtnCounter2.setOnClickListener(this);
        mBtnCounter3.setOnClickListener(this);
    }

    @Override
    public void setButtonText(int index, @NonNull String text) {
        switch (index) {
            case 0:
                mBtnCounter1.setText(text);
                break;
            case 1:
                mBtnCounter2.setText(text);
                break;
            case 2:
                mBtnCounter3.setText(text);
                break;

        }

    }

    @Override
    public void onClick(View view) {
        mPresenter.counterClick(btnsIDs.getOrDefault(view.getId(), 0));
    }

}
