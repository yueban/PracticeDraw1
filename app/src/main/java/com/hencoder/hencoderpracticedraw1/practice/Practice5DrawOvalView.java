package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {
    private final Paint mPaint = new Paint();
    private final RectF mRectF = new RectF();

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        int width = getWidth();
        int height = getHeight();

        int ovalWidth = 400;
        int ovalHeight = 200;
        int left = (width - ovalWidth) / 2;
        int top = (height - ovalHeight) / 2;

        mPaint.setAntiAlias(true);
        mRectF.set(left, top, left + ovalWidth, top + ovalHeight);
        canvas.drawOval(mRectF, mPaint);
    }
}
