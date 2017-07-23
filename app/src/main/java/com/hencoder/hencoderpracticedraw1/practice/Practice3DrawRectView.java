package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    private final Paint mPaint = new Paint();

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        int width = getWidth();
        int height = getHeight();
        int rectWidth = 300;
        int rectHeight = 200;
        int left = (width - rectWidth) / 2;
        int top = (height - rectHeight) / 2;

        mPaint.setColor(Color.DKGRAY);
        canvas.drawRect(left, top, left + rectWidth, top + rectHeight, mPaint);
    }
}
