package com.dobbby.obsession.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.dobbby.obsession.R;
import com.dobbby.obsession.bean.GameCharacter;
import com.dobbby.obsession.view.IShowGameView;

public class MainActivity extends AppCompatActivity implements IShowGameView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showGameOver() {

    }

    @Override
    public void showJumping(GameCharacter gameCharacter) {

    }

    @Override
    public void showRunning() {

    }

    @Override
    public void showBackgroundMoving() {

    }
}
