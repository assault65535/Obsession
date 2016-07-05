package com.dobbby.obsession.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.dobbby.obsession.bean.GameCharacter;

/**
 * Created by Dobbby on 16/7/5.
 */
public class CharacterView extends View {
    private GameCharacter gameCharacter;
    private Paint paint;

    public CharacterView(Context context) {
        super(context);
    }

    public CharacterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CharacterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        canvas.drawCircle(50, 50, 50, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(100, 100);
    }
}
