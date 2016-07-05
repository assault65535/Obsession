package com.dobbby.obsession.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.dobbby.obsession.bean.Trap;

/**
 * Created by Dobbby on 16/7/5.
 */
public class TrapView extends View {
    private Trap trap;
    private Paint paint;

    public TrapView(Context context) {
        super(context);
    }

    public TrapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TrapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Trap getTrap() {
        return trap;
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
    }

    public void setTrap(Trap trap) {
        this.trap = trap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        canvas.drawLine(0, trap.getHeight(), trap.getWidth(), trap.getHeight(), paint);
        canvas.drawLine(0, 0, 0, trap.getHeight(), paint);
        canvas.drawLine(trap.getWidth(), 0, trap.getWidth(), trap.getHeight(), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(trap.getWidth(), trap.getHeight());
    }
}
