package com.dobbby.obsession.view;

import com.dobbby.obsession.bean.GameCharacter;

/**
 * Created by Dobbby on 16/7/5.
 */
public interface IShowGameView {
    void showGameOver();

    void showJumpingAnimation(GameCharacter gameCharacter);

    void showRunningAnimation();
}
