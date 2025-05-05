package com.example.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class tictactoeboard extends View {
    private final int boardcolor;
    private final int XColor;
    private final int OColor;
    private final int WinningLinecolor;
    private final Paint paint = new Paint();
    private int cellSize = getWidth()/3;
    public tictactoeboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.tictactoeboard,0,0);
        try{
            boardcolor = a.getInteger(R.styleable.tictactoeboard_boardcolor,0);
            XColor = a.getInteger(R.styleable.tictactoeboard_XColor,0);
            OColor = a.getInteger(R.styleable.tictactoeboard_OColor,0);
            WinningLinecolor = a.getInteger(R.styleable.tictactoeboard_WinningLinecolor, 0);
        }finally {
            a.recycle();
        }
    }
    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width,height);
        int dimensions = Math.min(getMeasuredWidth(),getMeasuredHeight());
        cellSize = dimensions/3;
        setMeasuredDimension(dimensions, dimensions);
    }
    @Override
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        drawGameBoard(canvas);
    }
    private void drawGameBoard(Canvas canvas){
        paint.setColor(boardcolor);
        paint.setStrokeWidth(16);
        for(int c= 1; c < 3; c++){
            canvas.drawLine(cellSize*c, 0, cellSize*c, getWidth(), paint);
        }
        for(int r= 1; r < 3; r++){
            canvas.drawLine(0, cellSize*r, getWidth(), cellSize*r, paint);
        }
    }
}
