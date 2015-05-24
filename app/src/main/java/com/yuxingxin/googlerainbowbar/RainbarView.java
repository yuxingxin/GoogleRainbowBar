package com.yuxingxin.googlerainbowbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Sean on 15/5/24.
 */
public class RainbarView extends View{

    private Context context;

    //bar color
    private int barColor = Color.parseColor("#19A96F");

    //bar width
    private float barWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,getResources().getDisplayMetrics());

    //bar height
    private float barHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getResources().getDisplayMetrics());

    //spaces between bars
    private float space = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics());

    private float startX = 0;
    private float delta = 10f;
    private Paint mPaint;

    public RainbarView(Context context){
        super(context);
    }

    public RainbarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RainbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.rainbar,defStyleAttr,0);
        barWidth = array.getDimensionPixelSize(R.styleable.rainbar_barwidth,(int)barWidth);
        barHeight = array.getDimensionPixelSize(R.styleable.rainbar_barheight,(int)barHeight);
        space = array.getDimensionPixelSize(R.styleable.rainbar_space,(int)space);
        barColor = array.getColor(R.styleable.rainbar_barcolor, barColor);
        array.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(barColor);
        mPaint.setStrokeWidth(barHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float sw = this.getMeasuredWidth();
        if (startX >= sw + (barWidth + space) - (sw % (barWidth + space))){
            startX = 0;
        }else {
            startX += delta;
        }

        float start = startX;

        while (start < sw){
            canvas.drawLine(start,5f,start + barWidth,5f,mPaint);
            start += (space + barWidth);
        }

        start = startX - barWidth - space;

        while (start >= -barWidth){
            canvas.drawLine(start,5,start + barWidth,5,mPaint);
            start -= (space + barWidth);
        }

        invalidate();

    }
}
