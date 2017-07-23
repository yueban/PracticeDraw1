package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        int width = getWidth();
        int height = getHeight();

        //mPath.addCircle(width / 2, height / 2, 200, Path.Direction.CW);

        //mPaint.setStyle(Paint.Style.STROKE);
        //mPath.lineTo(100, 100);
        //mPath.rLineTo(0, 100);
        //mPath.rLineTo(100,0);

        //mPaint.setStyle(Paint.Style.STROKE);
        //mPath.quadTo(100, 100, 50, 200);
        //mPath.rQuadTo(100, 100, 50, 200);
        //mPath.rCubicTo(100, 100, 50, 200, 200, 200);
        //mPath.rCubicTo(100, 50, 50, 100, 200, -100);

        //mPaint.setStyle(Paint.Style.STROKE);
        //mPath.lineTo(100,100);
        //addArc 即 arcTo(...,true)
        //mPath.addArc(100, 100, 200, 200, -90, 90);
        //mPath.arcTo(100, 100, 200, 200, -90, 90, true);
        //mPath.arcTo(100, 100, 200, 200, -90, 90, false);
        //mPath.close();

        //int radius = 200;
        //mPath.setFillType(Path.FillType.WINDING);
        //mPath.setFillType(Path.FillType.EVEN_ODD);
        //mPath.setFillType(Path.FillType.INVERSE_WINDING);
        //mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        //mPath.addCircle(width / 2 - radius / 2, height / 2, radius, Path.Direction.CW);
        //mPath.addCircle(width / 2 + radius / 2, height / 2, radius, Path.Direction.CW);
        //mPath.addCircle(width / 2 + radius / 2, height / 2, radius, Path.Direction.CCW);

        canvas.translate(width / 2, height / 2);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        int heartW = 400;
        int heartH = 250;
        int radius = heartW / 4;

        mPath.arcTo(-radius * 2, -radius, 0, radius, 150, 210, true);
        mPath.addArc(0, -radius, radius * 2, radius, 180, 210);
        mPath.lineTo(0, heartH);
        double radians15 = Math.toRadians(15);
        double v = radius * Math.cos(radians15) * 2;
        mPath.lineTo(-(float) (v * Math.cos(radians15)), (float) (v * Math.sin(radians15)));
        //mPath.close();
        canvas.drawPath(mPath, mPaint);
    }
}
