package com.Tnecesoc.presenter;

import android.os.Handler;
import com.Tnecesoc.view.IShowGameView;
import com.dobbby.obsession.bean.Trap;
import com.dobbby.obsession.model.ITrapGenerator;
import com.dobbby.obsession.model.TrapGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tnecesoc on 2016/7/7.
 */
public class GamePresenter extends Handler {

    /**
     * 主角能跳几格
     */
    public static final int HOVER_LENGTH = 2;

    /**
     * 主角的位置，这里的意思是在中间的那个 TextView 上面
     * */
    public static final int HERO_POSITION = 2;


    private IShowGameView showGameView;
    private ITrapGenerator trapGenerator;
    private List<Trap> trapList;

    private boolean isGameStarted = false;


    private int clickPos;

    //是否在跳跃中
    private boolean isOnAir;
    //跳跃滞空计数, 当 cnt++ > HOVER_LENGTH 时 showHeroJumpingDown().
    private int hoverCount;

    public GamePresenter(IShowGameView showGameView) {
        this.showGameView = showGameView;
        this.trapGenerator = new TrapGenerator();
        this.trapList = new ArrayList<Trap>();
    }

    public void initilizeTrapList() {

        trapList.clear();

        for (int i = 0; i < 5; i++) {
            trapList.add(
                    new Trap().setShape(Trap.PLAIN)
            );
        }

    }

    public boolean isGameStarted() {
        return this.isGameStarted;
    }

    public void start() {

        if (isGameStarted) {
            return;
        }

        isGameStarted = true;

        /**
         * Things that the new thread which is about to start should do:
         *  1. judge if the move right
         *  2. if true, forward() and sleep 300ms then go to 1.
         *  3. if false, showGameOver() and end this thread.
         * */

        initilizeTrapList();

        isOnAir = false;

        showGameView.showGameStart();

        this.post(new Runnable() {
            @Override
            public void run() {

                forward();

                if (judge()) {
                    postDelayed(this, 200);
                } else {
                    showGameView.showGameOver();
                    isGameStarted = false;
                }

            }
        });

    }

    private void forward() {

        heroMarch();

        String newTrapInfo;
        Trap newTrap = trapGenerator.generateTrap();

        refreshTrapList(newTrap, 4);

        if (isOnAir) {
            showGameView.showHeroJumping();
        } else {
            showGameView.showHeroRunning();
        }

        showGameView.showSceneRefreshing(trapList);


    }

    public void performJump() {

        isOnAir = true;

    }

    private boolean judge() {

        String currentPosition = trapList.get(HERO_POSITION).toString();

        return isOnAir || (!currentPosition.equals("Rect"));

    }

    private void heroMarch() {

        isOnAir = isOnAir && hoverCount++ < HOVER_LENGTH;

        if (!isOnAir) {
            hoverCount = 0;
        }

    }

    private void refreshTrapList(Trap newTrap, int newTrapPos) {
        int len = trapList.size();

        boolean isNewTrapNeeded = true;

        for (int i = 0; i < len; i++) {
            if (trapList.get(i).getShape() != Trap.PLAIN) {
                isNewTrapNeeded = false;
                break;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            trapList.get(i).setShape(trapList.get(i + 1).getShape());
            trapList.get(i).setTriangleDirection(trapList.get(i + 1).getTriangleDirection());
        }

        trapList.get(len - 1).setShape(Trap.PLAIN);

        if (isNewTrapNeeded) {
            trapList.get(newTrapPos).setShape(newTrap.getShape());
            trapList.get(newTrapPos).setTriangleDirection(newTrap.getTriangleDirection());
        }
    }

}
