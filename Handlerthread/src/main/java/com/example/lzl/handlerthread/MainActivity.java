package com.example.lzl.handlerthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private HandlerThread handlerThread;
    private TextView mTv;
    public Handler mHandler;
    public Looper mLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv= (TextView) findViewById(R.id.test);
        Log.d("TAG",Thread.currentThread().getId()+"====onCreate======");
        handlerThread=new HandlerThread("search cost city thread");
        handlerThread.start();
        mLooper=handlerThread.getLooper();
        mHandler=new Handler(mLooper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                /**
                 * handler关联子线程LOOPER 在子线程中处理消息
                 */
//                mTv.setText("启动线程");
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mTv.setText("启动线程");
//                    }
//                });
                Log.d("TAG",Thread.currentThread().getId()+"====handleMessage======");
                mTv.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("TAG",Thread.currentThread().getId()+"====Runnable======");
                        mTv.setText(" 异步消息");
                    }
                });
            }
        };
        Log.d("TAG",Thread.currentThread().getId()+"====new Handler======");

    }

    public void testOnClick(View view){
       Message message=Message.obtain();
        message.obj="test";
        message.what=0;
        mHandler.sendMessage(message);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeMessages(0);
        handlerThread.getLooper().quit();
        handlerThread.quit();
        super.onDestroy();
    }
}
