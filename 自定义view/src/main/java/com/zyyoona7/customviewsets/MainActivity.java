package com.zyyoona7.customviewsets;

import android.os.Bundle;
import android.widget.Button;

import com.zyyoona7.customviewsets.basic_operation.BasicOperationActivity;
import com.zyyoona7.customviewsets.overlay_card.ZoomHoverActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_basic_operation)
    Button mBtnBasicOp;

    @BindView(R.id.btn_overlay_card)
    Button mBtnOverlayCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_basic_operation)
    void basicOpClick() {
        goTo(BasicOperationActivity.class);
    }

    @OnClick(R.id.btn_overlay_card)
    void overlayCardClick(){
        goTo(ZoomHoverActivity.class);
    }
}
