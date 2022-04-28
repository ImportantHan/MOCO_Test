package com.example.moco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoininfoActivity extends AppCompatActivity {

    Button find_join_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joininfo);

        find_join_btn = findViewById(R.id.find_join_btn);

        find_join_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9669-5005"));
                // call 기능에 대한 권한 체크하기
                if(ContextCompat.checkSelfPermission(JoininfoActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(JoininfoActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 0);
                }
                startActivity(intent);
            }
        });
    }
}