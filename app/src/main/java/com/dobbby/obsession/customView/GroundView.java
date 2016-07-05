package com.dobbby.obsession.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.dobbby.obsession.bean.Ground;

/**
 * Created by Dobbby on 16/7/5.
 */
public class GroundView extends View {
    private Ground ground;
    private final int STROKE = 2;
    private Paint paint;

    public GroundView(Context context) {
        super(context);
    }

    public GroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Ground getGround() {
        return ground;
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE);
        canvas.drawLine(0, 0, ground.getLength(), 0, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ground.getLength(), STROKE);
    }
}
