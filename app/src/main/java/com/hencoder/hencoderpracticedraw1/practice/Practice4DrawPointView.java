package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    private final Paint mPaint = new Paint();

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        int width = getWidth();
        int height = getHeight();
        int offset = 200;

        mPaint.setStrokeWidth(40);
        //在画笔首尾处的处理 setStrokeCap
        //默认 BUTT，不添加任何处理
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(width / 2 - offset, height / 2, mPaint);

        //默认 ROUND，首尾添加圆型
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(width / 2, height / 2, mPaint);

        //默认 ROUND，首尾添加方形
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(width / 2 + offset, height / 2, mPaint);

        int startX = width / 2 - offset;
        int startY = height / 2 + 100;
        int gap = 100;
        float[] points = {
            startX, startY, startX + gap, startY, startX + gap * 2, startY, startX, startY + gap, startX + gap, startY + gap,
            startX + gap * 2, startY + gap, startX, startY + gap * 2, startX + gap, startY + gap * 2, startX + gap * 2,
            startY + gap * 2,
        };

        canvas.drawPoints(points, 0, points.length, mPaint);
    }
}
