package com.Tnecesoc.view;

import com.dobbby.obsession.bean.Trap;

import java.util.List;

/**
 * Created by Tnecesoc on 2016/7/7.
 */
public interface IShowGameView {

    void showGameStart();

    void showGameOver();

    void showHeroJumping();

    void showHeroJumpngDown();

    void showHeroRunning();

    void showSceneRefreshing(List<Trap> newTrapsInfo);

}
