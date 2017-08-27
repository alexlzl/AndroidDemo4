package com.example.lzl.qq;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * describe：
 * <p>
 * author：lzl
 * <p>
 * date：16/7/22 下午2:08   ：
 */

public class QQTrembleAni extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.getMatrix().setTranslate(
                (float) Math.sin(interpolatedTime * 50) * 80,
                (float) Math.sin(interpolatedTime * 50) * 80
        );// 50越大频率越高，8越小振幅越小
        super.applyTransformation(interpolatedTime, t);
    }
}
