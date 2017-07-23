package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.Map;

public class Practice10HistogramView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = getWidth();
        int height = getHeight();
        int count = DataSource.HISTOGRAM_PLATFORMS.size();
        int blank = 100;//条形图与边缘间距
        int horizontalOffset = 20;//两条数据水平间距
        int verticalOffset = 30;//最高一条数据与图顶部间距

        int maxPercent = 0;
        for (int percent : DataSource.HISTOGRAM_PLATFORMS.values()) {
            maxPercent = Math.max(maxPercent, percent);
        }

        float elementWidth = (float) ((width - blank * 2 - horizontalOffset) * 1.0 / count - horizontalOffset);
        float elementHeightPixelPercent = (float) ((height - blank * 2 - verticalOffset) * 1.0 / maxPercent);

        //画坐标轴
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(blank, blank, blank, height - blank, mPaint);
        canvas.drawLine(blank, height - blank, width - blank, height - blank, mPaint);

        //画柱状图
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);

        mTextPaint.setTextSize(24);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        float startX = blank + horizontalOffset;
        int y = height - blank;
        for (Map.Entry<String, Integer> platform : DataSource.HISTOGRAM_PLATFORMS.entrySet()) {
            String title = platform.getKey();
            int percent = platform.getValue();
            //绘制文字
            canvas.drawText(title, startX + elementWidth / 2, y + mTextPaint.descent() - mTextPaint.ascent(), mTextPaint);
            //绘制柱状图
            canvas.drawRect(startX, y - elementHeightPixelPercent * percent, startX = startX + elementWidth, y, mPaint);

            startX += horizontalOffset;
        }
    }
}
