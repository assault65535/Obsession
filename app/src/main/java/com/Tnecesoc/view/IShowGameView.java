package com.Tnecesoc.view;

/**
 * Created by Tnecesoc on 2016/7/7.
 */
public interface IShowGameView {

    void showGameStart();

    void showGameOver();

    void showHeroJumping();

    void showHeroJumpngDown();

    void showHeroRunning();

    void showSceneRefreshing(String newTrapInfo, int newTrapPos);

}
