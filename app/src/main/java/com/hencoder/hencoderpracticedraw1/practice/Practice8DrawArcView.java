package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF mRectF = new RectF();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int width = getWidth();
        int height = getHeight();
        canvas.translate(width / 2, height / 2);

        int OvalWidth1 = 100;
        int OvalHeight1 = 200;
        int OvalWidth2 = 300;
        int OvalHeight2 = 200;
        int OvalWidth3 = 200;
        int OvalHeight3 = 200;

        //画扇形
        mRectF.set(-OvalWidth1 / 2, -OvalHeight1 / 2, OvalWidth1 / 2, OvalHeight1 / 2);
        canvas.drawArc(mRectF, 0, 80, true, mPaint);
        //画圆弧扫过的点连接成的面
        //useCenter:false,不连接到圆心
        mRectF.set(-OvalWidth2 / 2, -OvalHeight2 / 2, OvalWidth2 / 2, OvalHeight2 / 2);
        canvas.drawArc(mRectF, 90, 100, false, mPaint);
        //画圆弧
        //useCenter:false,不连接到圆心
        //Paint.Style.STROKE:画线模式
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mRectF.set(-OvalWidth3 / 2, -OvalHeight3 / 2, OvalWidth3 / 2, OvalHeight3 / 2);
        canvas.drawArc(mRectF, 200, 100, false, mPaint);
    }
}
