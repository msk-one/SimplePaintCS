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

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canv) {
        canv.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canv.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent mev) {
        float tx = mev.getX();
        float ty = mev.getY();

        if (mev.getAction() == MotionEvent.ACTION_DOWN) {
            drawPath.moveTo(tx, ty);
        }
        else if (mev.getAction() == MotionEvent.ACTION_MOVE) {
            drawPath.lineTo(tx, ty);
        }
        else if (mev.getAction() == MotionEvent.ACTION_UP) {
            drawCanvas.drawPath(drawPath, drawPaint);
            drawPath.reset();
        }
        else {
            return false;
        }

        invalidate();
        return true;
    }


}
