package com.dobbby.obsession.view;

import com.dobbby.obsession.bean.GameCharacter;

/**
 * Created by Dobbby on 16/7/5.
 */
public interface IShowGameView {
    void showGameOver();

    void showJumping(GameCharacter gameCharacter);

    void showRunning();

    void showBackgroundMoving();
}
