package com.example.railkamalov.rxjavatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Rx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Observable.just("one", "two", "three", "four")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(s -> s.hashCode())
                .subscribe(
                        o -> Log.d(TAG, "Hello " + o + "!"),
                        e -> Log.d(TAG, "onError"),
                        () -> Log.d(TAG, "onCompleted")
                        );


    }

}
