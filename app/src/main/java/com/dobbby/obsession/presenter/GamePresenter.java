package com.dobbby.obsession.presenter;

import android.os.Handler;
import com.dobbby.obsession.bean.GameCharacter;
import com.dobbby.obsession.model.IReceiveClick;
import com.dobbby.obsession.model.ITrapGenerator;
import com.dobbby.obsession.model.OnUserClickListener;
import com.dobbby.obsession.model.ReceiveClick;
import com.dobbby.obsession.view.IShowGameView;

/**
 * Created by Dobbby on 16/7/5.
 */
public class GamePresenter {
    private IShowGameView showGameView;
    private ITrapGenerator trapGenerator;
    private IReceiveClick receiveClick;
    private Handler handler = new Handler();
    private GameCharacter gameCharacter;

    public GamePresenter(IShowGameView showGameView) {
        this.showGameView = showGameView;
        this.receiveClick = new ReceiveClick();
    }

    public void sample() {
        receiveClick.judgeClick(1, new OnUserClickListener() {
            @Override
            public void wrongClick() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        showGameView.showJumping(gameCharacter);
                        showGameView.showGameOver();
                    }
                });
            }

            @Override
            public void rightClick() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        showGameView.showJumping(gameCharacter);
                    }
                });
            }
        });
    }
}
