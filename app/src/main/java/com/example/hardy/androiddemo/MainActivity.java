package com.example.hardy.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private Button mBtnModify;
   private TextView mTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
    }

    private void initView(){
        mBtnModify = findViewById(R.id.btn_modify);
        mTextTitle = findViewById(R.id.text_title);
    }

    private void setListener(){
        mBtnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextTitle.setText("instant run failed!");
            }
        });
    }
}
