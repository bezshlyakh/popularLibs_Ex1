package com.geekbrains.mvp.presenter;

import com.geekbrains.mvp.R;
import com.geekbrains.mvp.model.CounterModel;
import com.geekbrains.mvp.view.MainView;

import java.util.ArrayList;

public class MainPresenter {
    private CounterModel mModel = new CounterModel();
    private MainView mView;

    public MainPresenter(MainView view) {
        if (view == null) throw new IllegalArgumentException("View cannot be null");

        mView = view;
    }

    public void counterClick(int id) {
        switch (id) {
            case 0:
                break;

            case 1:
                mView.setButtonText(0, String.valueOf(mModel.next(0)));
                break;

            case 2:
                mView.setButtonText(1, String.valueOf(mModel.next(1)));
                break;

            case 3:
                mView.setButtonText(2, String.valueOf(mModel.next(2)));
                break;
        }
    }
}
