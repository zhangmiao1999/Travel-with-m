package com.example.withm.ui.xzqfragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withm.R;

public class AdventureActivity extends AppCompatActivity {

    private ImageView img_back;
    private Toolbar toolBar;
    private ImageView imageView2;
    private TextView textView3;
    private TextView textView4;
    private Button follow;
    private CardView cd;
    private ImageView fish;
    private TextView tv1;
    private TextView textView;
    private ImageView iv1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);
        initView();
    }

    private void initView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        follow = (Button) findViewById(R.id.imageView3);
        cd = (CardView) findViewById(R.id.cd);
        fish = (ImageView) findViewById(R.id.fish);
        tv1 = (TextView) findViewById(R.id.tv1);
        textView = (TextView) findViewById(R.id.textView);
        iv1 = (ImageView) findViewById(R.id.iv1);
        textView2 = (TextView) findViewById(R.id.textView2);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdventureActivity.this, PhotoActivity.class));
            }
        });
        //     follow.setClickable(true);
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdventureActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
