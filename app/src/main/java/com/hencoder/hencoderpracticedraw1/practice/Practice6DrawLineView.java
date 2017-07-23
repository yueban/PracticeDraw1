package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线

        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        int wordWidth = 200;
        int wordHeight = 200;
        int wordGap = 60;
        int secondWordX = wordWidth + wordGap;

        canvas.translate(getWidth() / 2 - wordWidth - wordGap / 2, getHeight() / 2 - wordHeight / 2);
        float[] points = {
            0, 0, wordWidth, 0, wordWidth / 2, 0, wordWidth / 2, wordHeight, 0, wordHeight, wordWidth, wordHeight, secondWordX, 0,
            secondWordX + wordWidth, 0, secondWordX, 0, secondWordX, wordHeight, secondWordX + wordWidth, 0,
            secondWordX + wordWidth, wordHeight, secondWordX, wordHeight, secondWordX + wordWidth, wordHeight
        };
        canvas.drawLines(points, mPaint);
    }
}
