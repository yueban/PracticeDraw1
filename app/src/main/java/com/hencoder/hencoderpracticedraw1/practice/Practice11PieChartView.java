package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.Map;
import java.util.Random;

public class Practice11PieChartView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF mRectF = new RectF();
    private final Path mLinePath = new Path();
    private final Random mRandom = new Random();

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPathPaint.setColor(Color.WHITE);
        mPathPaint.setStrokeWidth(2);
        mPathPaint.setStyle(Paint.Style.STROKE);

        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(24);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int width = getWidth();
        int height = getHeight();
        int radius = 200;
        int lineEdgeOffset = 20;
        int textLineOffset = 5;
        canvas.translate(width / 2, height / 2);
        mRectF.set(-radius, -radius, radius, radius);

        float startAngle = 0;
        for (Map.Entry<String, Integer> platform : DataSource.CHART_PLATFORMS.entrySet()) {
            String title = platform.getKey();
            int percent = platform.getValue();

            int color = Color.rgb(mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
            mPaint.setColor(color);
            float sweepAngle = percent / 100.0f * 360;
            float centerAngle = startAngle + sweepAngle / 2;
            double centerRadians = Math.toRadians(centerAngle);
            //使扇形整体绘制偏移，远离圆心
            int centerOffset = 20;
            double cos = Math.cos(centerRadians);
            double sin = Math.sin(centerRadians);
            float dx = (float) cos * centerOffset;
            float dy = (float) sin * centerOffset;
            //移动 canvas，使扇形整体绘制偏移，远离圆心
            canvas.translate(dx, dy);
            canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);
            //绘制线
            int lineOffset = 20;
            float lineX = (float) (radius * cos + lineOffset * cos);
            float lineY = (float) (radius * sin + lineOffset * sin);
            final float textX;
            final float textY = lineY + mTextPaint.descent();
            final int lineEndX;
            mLinePath.reset();
            mLinePath.moveTo((float) (radius * cos), (float) (radius * sin));
            mLinePath.lineTo(lineX, lineY);
            if (cos > 0) {
                mTextPaint.setTextAlign(Paint.Align.LEFT);
                lineEndX = radius + lineOffset + lineEdgeOffset;
                textX = lineEndX + textLineOffset;
                mLinePath.lineTo(lineEndX, lineY);
            } else {
                mTextPaint.setTextAlign(Paint.Align.RIGHT);
                lineEndX = -radius - lineOffset - lineEdgeOffset;
                textX = lineEndX - textLineOffset;
                mLinePath.lineTo(lineEndX, lineY);
            }
            canvas.drawPath(mLinePath, mPathPaint);
            //画文字
            canvas.drawText(title, textX, textY, mTextPaint);
            //canvas 归位
            canvas.translate(-dx, -dy);
            startAngle += sweepAngle;
        }
    }
}
