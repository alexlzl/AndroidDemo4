package com.example.lzl.testfragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * 一般情况下，您不得使用 onPause() 永久性存储用户更改（比如输入表格的个人信息）。 只有在您确定用户希望自动保存这些更改的情况（比如，电子邮件草稿）下，才能在 onPause()中永久性存储用户更改。但您应避免在 onPause() 期间执行 CPU 密集型工作，比如向数据库写入信息，因为这会拖慢向下一Activity过渡的过程（您应改为在 onStop()期间执行高负载关机操作。
 * <p>
 * 您应通过相对简单的方式在 onPause() 方法中完成大量操作，这样才能加快在您的Activity确实停止的情况下用户向下一个目标过渡的速度。
 * <p>
 * 注意：当您的Activity暂停时，Activity 实例将驻留在内存中并且在Activity继续时被再次调用。您无需重新初始化在执行任何导致进入“继续”状态的回调方法期间创建的组件
 */
public class MainActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "MainActivity===onCreate");
        gestureDetector = new GestureDetector(this, new
                GestureListenerImpl());

    }

    public void testOnClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认退出吗?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();

    }


    public void dialogActivity(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);

    }


    public void testPopupWindow(View view) {
        showPopupWindow(view);
    }

    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.popup_window, null);


        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, 200, true);

        popupWindow.setTouchable(true);


        popupWindow.setBackgroundDrawable(new ColorDrawable());

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

    }

    public void testToast(View view) {
        Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
//        setVisible(false);
    }

    public void secondActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "MainActivity===onRestoreInstanceState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("TAG", "MainActivity===onSaveInstanceState===PersistableBundle");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAG", "MainActivity===onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "MainActivity===onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "MainActivity===onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        while (true) {
//            Log.d("TAG", "MainActivity===onPause");
//        }

    }

    /**
     * 当您的Activity收到 onStop() 方法的调用时，它不再可见，并且应释放几乎所有用户不使用时不需要的资源。 一旦您的Activity停止，如果需要恢复系统内存，系统可能会销毁该实例。 在极端情况下，系统可能会仅终止应用进程，而不会调用Activity的最终 onDestroy() 回调，因此您使用 onStop() 释放可能泄露内存的资源非常重要。
     * <p>
     * 尽管 onPause() 方法在 onStop()之前调用，您应使用 onStop() 执行更大、占用更多 CPU 的关闭操作，比如向数据库写入信息。
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "MainActivity===onStop");
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("TAG", "MainActivity===finish");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "MainActivity===onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "MainActivity===onRestart");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d("TAG", "MainActivity===onRestoreInstanceState");
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Log.d("TAG", "MainActivity===dispatchGenericMotionEvent");
        return super.dispatchGenericMotionEvent(ev);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("TAG", "MainActivity===dispatchTouchEvent");
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
//        return  false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TAG", "MainActivity===onTouchEvent");
        return super.onTouchEvent(event);
    }

    private class GestureListenerImpl implements GestureDetector.OnGestureListener {
        //触摸屏幕时均会调用该方法
        @Override
        public boolean onDown(MotionEvent e) {
//            System.out.println("---> 手势中的onDown方法");
            Log.d("TAG", "---> 手势中的onDown方法");
            return false;
        }

        //手指在屏幕上拖动时会调用该方法
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            System.out.println("---> 手势中的onFling方法");
            Log.d("TAG", "--->  手势中的onFling方法");
            return false;
        }

        //手指长按屏幕时均会调用该方法
        @Override
        public void onLongPress(MotionEvent e) {
//            System.out.println("---> 手势中的onLongPress方法");
            Log.d("TAG", "--->  手势中的onLongPress方法");
        }

        //手指在屏幕上滚动时会调用该方法
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            System.out.println("---> 手势中的onScroll方法");
            Log.d("TAG", "--->  手势中的onScroll方法");
            return false;
        }

        //手指在屏幕上按下,且未移动和松开时调用该方法
        @Override
        public void onShowPress(MotionEvent e) {
//            System.out.println("---> 手势中的onShowPress方法");
            Log.d("TAG", "--->  手势中的onShowPress方法");
        }


        //轻击屏幕时调用该方法
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
//            System.out.println("---> 手势中的onSingleTapUp方法");
            Log.d("TAG", "--->  手势中的onSingleTapUp方法");
            return false;
        }
    }
}
