package com.dobbby.obsession.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.Tnecesoc.presenter.GamePresenter;
import com.dobbby.obsession.R;


import com.Tnecesoc.view.IShowGameView;

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


        System.out.println();
        System.out.println(((TextView) findViewById(R.id.tv1)));

        heroPos_tv = (TextView) findViewById(R.id.tv3);
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
                gamePresenter.performActionWhileJudge(heroPos_tv.getText().toString(), true);
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
    public void showHeroRunning() {
        jumpHero_tv.setText("");
        hero_tv.setText(R.string.hero_normal);
    }

    @Override
    public void showSceneRefreshing(String newTrapInfo, int newTrapPos) {
        int len = trapOptionList.size();
        boolean isNewTrapNeeded = true;

        for (int i = 0; i < len - 1; i++) {
            trapOptionList.get(i).setText(trapOptionList.get(i + 1).getText());
        }

        for (int i = 0; i < len; i++) {
            if (!trapOptionList.get(i).getText().equals("Plain")) {
                isNewTrapNeeded = false;
                break;
            }
        }

        trapOptionList.get(len - 1).setText(R.string.plain_ground);

        if (isNewTrapNeeded) {
            trapOptionList.get(newTrapPos).setText(newTrapInfo);
        }

        System.out.println(((TextView) findViewById(R.id.tv1)).getText());

    }
}
