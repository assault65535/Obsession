package com.dobbby.obsession.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.Tnecesoc.presenter.GamePresenter;
import com.Tnecesoc.view.IShowGameView;
import com.dobbby.obsession.R;
import com.dobbby.obsession.bean.Trap;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowGameView {
    public float density;

    private GamePresenter gamePresenter = new GamePresenter(this);

    private TextView hero_tv;
    private TextView jumpHero_tv;
    private TextView heroPos_tv;
    private List<TextView> trapOptionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDensity();
        setContentView(R.layout.activity_main);

        hero_tv = (TextView) findViewById(R.id.hero_tv);
        jumpHero_tv = (TextView) findViewById(R.id.jumpHero_tv);

        trapOptionList = new ArrayList<TextView>() {{
            add((TextView) findViewById(R.id.tv1));
            add((TextView) findViewById(R.id.tv2));
            add((TextView) findViewById(R.id.tv3));
            add((TextView) findViewById(R.id.tv4));
            add((TextView) findViewById(R.id.tv5));
        }};

        heroPos_tv = trapOptionList.get(GamePresenter.HERO_POSITION);
    }

    private void setDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        density = metrics.density;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (!gamePresenter.isGameStarted()) {
                gamePresenter.start();
            } else {
                gamePresenter.performJump();
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void showGameStart() {
        showHeroJumping();
    }

    @Override
    public void showGameOver() {

        Toast.makeText(MainActivity.this, "Game over", Toast.LENGTH_SHORT).show();
        hero_tv.setText(R.string.hero_dead);

    }

    @Override
    public void showHeroJumping() {
        hero_tv.setText("");
        jumpHero_tv.setText(R.string.hero_jump);
    }

    @Override
    public void showHeroJumpngDown() {
        showHeroRunning();
    }

    @Override
    public void showHeroRunning() {
        jumpHero_tv.setText("");
        hero_tv.setText(R.string.hero_normal);
    }

    @Override
    public void showSceneRefreshing(List<Trap> newTrapsInfo) {

        int len = trapOptionList.size();

        for (int i = 0; i < len; i++) {
            trapOptionList.get(i).setText(newTrapsInfo.get(i).toString());
        }

    }
}
