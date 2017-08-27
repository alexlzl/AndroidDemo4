package com.hc.customlayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MyEntity> myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initData();

        MyLayoutManager layoutManager = new MyLayoutManager();
        MyAdapter adapter = new MyAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    //初始化数据
    private void initData() {
        int size = 30 ;
        myData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            MyEntity e = new MyEntity();
            e.setStr("str:" + i);
            myData.add(e);
        }
    }

    //自定义Adapter
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.recycler_view_item, parent, false);

            MyViewHolder viewHolder = new MyViewHolder(v);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MyEntity myEntity = myData.get(position);

            holder.setStr(myEntity.getStr());
        }

        @Override
        public int getItemCount() {
            return myData.size();
        }
    }

    //自定义Holder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView strTv;


        public MyViewHolder(View itemView) {
            super(itemView);
            strTv = (TextView) itemView.findViewById(R.id.str);
        }

        public void setStr(String str) {
            strTv.setText(str);
        }

    }
}
