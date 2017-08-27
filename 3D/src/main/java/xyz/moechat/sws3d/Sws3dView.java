package xyz.moechat.sws3d;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.renderscript.Matrix4f;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;


/**
 * Created by timeloveboy on 16/5/1.
 */
public class Sws3dView extends TextView {
    public Sws3dView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        mTextPaint = new TextPaint();

        // Set up a default TextPaint object
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
    }

    public int getRotate_X() {
        return rotate_X;
    }

    public void setRotate_X(int rotate_X) {
        this.rotate_X = rotate_X;
    }

    public int getRotate_Y() {
        return rotate_Y;
    }

    public void setRotate_Y(int rotate_Y) {
        this.rotate_Y = rotate_Y;
    }

    public int getRotate_Z() {
        return rotate_Z;
    }

    public void setRotate_Z(int rotate_Z) {
        this.rotate_Z = rotate_Z;
    }

    int rotate_X=80,rotate_Y=0,rotate_Z=0;

    public float getTranslate_Z() {
        return translate_Z;
    }

    public void setTranslate_Z(float translate_Z) {
        this.translate_Z = translate_Z;
    }

    public float getTranslate_X() {
        return translate_X;
    }

    public void setTranslate_X(float translate_X) {
        this.translate_X = translate_X;
    }

    public float getTranslate_Y() {
        return translate_Y;
    }

    public void setTranslate_Y(float translate_Y) {
        this.translate_Y = translate_Y;
    }

    float translate_X=0;
    float translate_Y=1000f;
    float translate_Z=1000f;

    public float getLocation_x() {
        return location_x;
    }

    public void setLocation_x(float location_x) {
        this.location_x = location_x;
    }

    public float getLocation_y() {
        return location_y;
    }

    public void setLocation_y(float location_y) {
        this.location_y = location_y;
    }

    public float getLocation_z() {
        return location_z;
    }

    public void setLocation_z(float location_z) {
        this.location_z = location_z;
    }

    float location_x=0, location_y=0, location_z=-8;
    public Camera getCamera() {
        return camera;
    }
    private Matrix mMatrix = new Matrix();
    Camera camera= new Camera();;
    private float mAngle = 60f;
    private float mScrollPosition = 0f;
    private float mEndScrollMult = 2f;
    private float mDistanceFromText = 0f;

    private TextPaint mTextPaint;
    private StaticLayout mTextLayout;
    protected void onDraw(Canvas canvas) {

//        int contentWidth = getWidth()  ;
//        int contentHeight = getHeight()  ;
//
//        final int saveCnt = canvas.save();
//
//        // Rotate/translate the camera
//        canvas.getMatrix(mMatrix);
//        camera.save();
//
//        int cX = contentWidth / 2  ;
//        int cY = contentHeight / 2 ;
//        camera.rotateX(mAngle);
//        camera.translate(0, 0, mDistanceFromText);
//        camera.getMatrix(mMatrix);
//        mMatrix.preTranslate(-cX, -cY);
//        mMatrix.postTranslate(cX, cY);
//        camera.restore();
//
//        canvas.concat(mMatrix);
//
//        // The end scroll multiplier ensures that the text scrolls completely out of view
//        canvas.translate(0f, contentHeight - mScrollPosition *
//                (getHeight() + mEndScrollMult * contentHeight));
//
//        // Draw the text
//        mTextLayout.draw(canvas);
//
//        canvas.restoreToCount(saveCnt);


        camera.save();
        camera.setLocation(location_x, location_y, location_z);

        camera.rotate(rotate_X, rotate_Y, rotate_Z);
        camera.translate(translate_X, translate_Y, translate_Z);

        Matrix4f matrix4f=new Matrix4f();
        camera.applyToCanvas(canvas);
        camera.restore();
        super.onDraw(canvas);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Measure and layout the text
        final CharSequence text = getText();
        measureAndLayoutText(text);
    }

    private void measureAndLayoutText(CharSequence text) {


        int availableWidth = getWidth()  ;
        mTextLayout = new StaticLayout(text, mTextPaint, availableWidth, Layout.Alignment.ALIGN_CENTER,
                1.1f, 0f, true);
    }
    //// TODO: 16/5/1
    //region 滚动
    int Duration=50;

/*

* override the computeScroll to restart scrolling when finished so as that

* the text is scrolled forever

*/
    // scrolling feature
    private Scroller mSlr;
    private boolean mPaused = true;
    @Override
    public void computeScroll() {

        super.computeScroll();

        if (null == mSlr) return;

        if (mSlr.isFinished() && (!mPaused)) {

            this.startScroll();

        }

    }

    public void startScroll() {
        mPaused = true;
        resumeScroll();
    }
    int x,y=0;
    public void resumeScroll() {

        if (!mPaused)
            return;

        setVerticalScrollBarEnabled(true);
        mSlr = new Scroller(this.getContext(), new LinearInterpolator());
        setScroller(mSlr);

        setVisibility(VISIBLE);
        int distance=10;
        x=0;
        y+=distance;
        mSlr.startScroll(x,y,distance / 2,distance, Duration);

        mPaused = false;
    }
    //endregion

}

