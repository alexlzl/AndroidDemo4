package com.example.lzl.qq;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout rlTremble;
    private Button btnTremble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlTremble = (ConstraintLayout) findViewById(R.id.activity_main);
        btnTremble = (Button) findViewById(R.id.bt);

        // 创建抖一抖动画对象
        final QQTrembleAni tremble = new QQTrembleAni();
        tremble.setDuration(800);// 持续时间800ms，持续时间越短频率越高
        tremble.setRepeatCount(2);// 重复次数，不包含第一次

        // 设置按钮点击监听
        btnTremble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动抖一抖效果
                rlTremble.startAnimation(tremble);
            }
        });
    }
}
