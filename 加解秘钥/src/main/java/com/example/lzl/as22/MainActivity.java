package com.example.lzl.as22;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static  final String  SP_NAME="sp_name";
    private  static  final  String SP_KEY="sp_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testIntent(View view) {
//        Intent intent=new Intent(this,TestIntent.class);
//       boolean iscan= isIntentAvailable(this,intent);
//        if(iscan){
//            startActivity(intent);
//        }
        Toast.makeText(this,"存储",Toast.LENGTH_LONG).show();
        SharedPreferences sp=getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor se=sp.edit();
        try {
            se.putString(SP_KEY,Des3Util.encode("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        se.commit();
    }


    public void testShow(View view){
        TextView tv= (TextView) view;
        Toast.makeText(this,"读取",Toast.LENGTH_LONG).show();
        SharedPreferences sp=getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        try {
            tv.setText(sp.getString(SP_KEY,"空值")+"解密后"+Des3Util.decode(sp.getString(SP_KEY,"空值")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testOnClick(View view){
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
    }



    public static boolean isIntentAvailable(Context context, Intent intent) {
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

}
