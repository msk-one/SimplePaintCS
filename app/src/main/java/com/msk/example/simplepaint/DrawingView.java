package com.msk.example.simplepaint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Msk on 2014-11-14.
 */
public class DrawingView extends View {
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = Color.BLACK; //default color
    private int defaultPaintWidth = 20;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;

    public DrawingView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.setupDrawingView();
    }

    private void setupDrawingView() {
        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setColor(paintColor);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(defaultPaintWidth);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }




}
