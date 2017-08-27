package co.lujun.testrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通过测试，得出以下结论：

 a.调用onCreateViewHolder(ViewGroup parent, int viewType)创建ViewHolder；

 b.滚动过程中，每次通过调用onBindViewHolder(ViewHolder holder, int position)绑定更新数据；

 c.当只有一种类型的item view的情况下，缓存创建的ViewHolder的个数为屏幕最多显示item view的个数+2；

 d.当有多种类型（>=2）的item view在RecyclerView中显示，每种类型的item view缓存创建的ViewHolder个数为其在屏幕中最多显示item view的个数+1。


 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final static int TYPE_0 = 0;
    private final static int TYPE_1 = TYPE_0 + 1;
    private final static int TYPE_2 = TYPE_1 + 1;

    private final int typeCount;

    public RecyclerViewAdapter(int typeCount){
        if(typeCount < 1){
            this.typeCount = 1;
        }else if (typeCount > 3){
            this.typeCount = 3;
        }else {
            this.typeCount = typeCount;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        Log.i("RecyclerViewAdapter", "onCreateViewHolder()======");
        if (getItemViewType(viewType) == TYPE_0){
            Log.i("RecyclerViewAdapter", "onCreateViewHolder()--TYPE_0");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_1, parent, false);
        }else if (getItemViewType(viewType) == TYPE_1){
            Log.i("RecyclerViewAdapter", "onCreateViewHolder()--TYPE_1");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_2, parent, false);
        }else {
            Log.i("RecyclerViewAdapter", "onCreateViewHolder()--TYPE_2");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_3, parent, false);
        }
        return new ViewHolder(view, getItemViewType(viewType));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_0){
            Log.i("RecyclerViewAdapter", "onBindViewHolder()--TYPE_0");
            holder.textView.setText(position + "");
        }else if (getItemViewType(position) == TYPE_1){
            Log.i("RecyclerViewAdapter", "onBindViewHolder()--TYPE_1");
//            holder.imageview.setImageResource(R.drawable.ic_launcher);
        }else {
            Log.i("RecyclerViewAdapter", "onBindViewHolder()--TYPE_2");
            holder.button.setText(position + "");
        }
    }

    @Override
    public int getItemCount() {
        if (typeCount == 1){
            return 24;
        }else if (typeCount == 2){
            return 36;
        }
        return 42;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (typeCount == 1){
            return TYPE_0;
        }else if (typeCount == 2){
            return position % 2 == 0 ? TYPE_0 : TYPE_1;
        }else {
            if (position % 3 == 0){
                return TYPE_0;
            }else if (position % 3 == 1){
                return TYPE_1;
            }else {
                return TYPE_2;
            }
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageview;
        Button button;

        public ViewHolder(View view, int type){
            super(view);
            switch (type){
                case 0:
                    textView = (TextView) view.findViewById(R.id.textview);
                    break;

                case 1:
                    imageview = (ImageView) view.findViewById(R.id.image);
                    break;

                case 2:
                    button = (Button) view.findViewById(R.id.button);
                    break;

                default:
                    break;
            }

        }
    }
}
