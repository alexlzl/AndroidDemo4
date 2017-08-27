package com.example.lzl.testweb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
  protected void onClick(View view){
      test(null);
  }
    private void test(@NonNull String param){
        Toast.makeText(this,param,Toast.LENGTH_LONG).show();

    }
}
