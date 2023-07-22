package com.example.jongtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class first extends AppCompatActivity {
    private ImageButton button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button1 = (ImageButton) findViewById(R.id.imageButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData((Uri.parse("http://www.amc.seoul.kr/asan/healthinfo/disease/diseaseDetail.do?contentId=31545#:~:text=%ED%94%BC%EB%B6%80%EC%95%94%EC%9D%80%20%ED%94%BC%EB%B6%80%EC%97%90%20%EB%B0%9C%EC%83%9D,%EC%A2%85%EC%9D%B4%20%EB%8C%80%EB%B6%80%EB%B6%84%EC%9D%84%20%EC%B0%A8%EC%A7%80%ED%95%A9%EB%8B%88%EB%8B%A4.&text=%ED%94%BC%EB%B6%80%EC%95%94%EC%9D%80%20%ED%96%87%EB%B9%9B%EC%97%90%20%EC%9D%98%ED%95%9C%20%EC%86%90%EC%83%81%EC%9D%B4%20%EC%A3%BC%EC%9A%94%20%EC%9B%90%EC%9D%B8%EC%9E%85%EB%8B%88%EB%8B%A4.")));
                startActivity(i);
            }
        });
    }
}