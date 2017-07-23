package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private final Paint paint = new Paint();

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        int width = getWidth();
        int height = getHeight();

        int minWidth = Math.min(width, height);
        int measuredRadius = minWidth / 4;
        int radiusOffset = 10;
        int radius = measuredRadius - radiusOffset;

        int startX = (width - minWidth) / 2 + measuredRadius;
        int startY = (height - minWidth) / 2 + measuredRadius;

        paint.setColor(Color.RED);
        canvas.drawCircle(startX, startY, radius, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(startX + measuredRadius * 2, startY, radius, paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(20);
        canvas.drawCircle(startX, startY + measuredRadius * 2, radius, paint);

        paint.setColor(Color.CYAN);
        paint.setAntiAlias(true);
        canvas.drawCircle(startX + measuredRadius * 2, startY + measuredRadius * 2, radius, paint);
    }
}
