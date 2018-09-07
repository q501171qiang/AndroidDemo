package com.example.hardy.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hardy";
    private TextView mTextTitle;
    private Button mBtnTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setListener();
    }

    private void initView(){
        mTextTitle = findViewById(R.id.text_title);
        mBtnTest = findViewById(R.id.btn_test);
    }

    private void initData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getMainLooper().getThread() == Thread.currentThread()){
                    mTextTitle.setText("OnCreate Main Thread");
                }else{
                    mTextTitle.setText("OnCreate Child Thread");
                }
            }
        }).start();
    }

    private void setListener(){
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getMainLooper().getThread() == Thread.currentThread()){
                    mTextTitle.setText("setListener Main Thread");
                }else{
                    mTextTitle.setText("setListener Child Thread");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //这里会闪退，因为在子线程中操作UI
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getMainLooper().getThread() == Thread.currentThread()){
                    mTextTitle.setText("onPause Main Thread");
                }else{
                    mTextTitle.setText("onPause Child Thread");
                }
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (getMainLooper().getThread() == Thread.currentThread()){
                    mTextTitle.setText("onResume Main Thread");
                }else{
                    mTextTitle.setText("onResume Child Thread");
                }
            }
        }).start();
    }
}
