package com.zff.aspectjdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textClick();
//                textClick111();
                textClickkkk();
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"dianji le anniu ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @ToastMethodName()
    public String textClick(){
        return "我是返回值";
    }

//    @ToastMethodName()
//    public void textClick111(){
//
//    }

    @ToastMethodName("你好呀，哥哥")
    public void textClickkkk(){

    }
}