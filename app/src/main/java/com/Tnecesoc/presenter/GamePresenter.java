package com.Tnecesoc.presenter;

import android.os.Handler;
import com.Tnecesoc.handler.GameHandler;
import com.Tnecesoc.view.IShowGameView;
import com.dobbby.obsession.bean.Trap;
import com.dobbby.obsession.model.ITrapGenerator;
import com.dobbby.obsession.model.TrapGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tnecesoc on 2016/7/7.
 */
public class GamePresenter {

    /**
     * 主角能跳几格
     */
    public static final int HOVER_LENGTH = 1;


    private IShowGameView showGameView;
    private ITrapGenerator trapGenerator;
    private Handler gameHandler = new GameHandler();
    private List<Trap> trapList;

    private boolean isGameStarted = false;


    private int clickPos;

    //跳跃滞空计数, 当 cnt == HOVER_LENGTH 时 showHeroJumpingDown().
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
         *  2. if true, forward() and sleep 500ms then go to 1.
         *  3. if false, showGameOver() and end this thread.
         * */

        initilizeTrapList();

        gameHandler.post(new Runnable() {
            @Override
            public void run() {


                forward();

                gameHandler.postDelayed(this, 300);



            }
        });

    }

    public void forward() {

        String newTrapInfo;
        Trap newTrap = trapGenerator.generateTrap();

        showGameView.showHeroRunning();
        showGameView.showSceneRefreshing(newTrap.toString(), 4);

        refreshTrapList(newTrap, 4);
    }

    public boolean performActionWhileJudge(String currentTrapInfo, boolean isJumped) {
        boolean ans = currentTrapInfo != "Rect" || isJumped;

        if (isJumped) {
            showGameView.showHeroJumping();
        }

        return ans;
    }

    private boolean isOnAir() {
        if (hoverCount == )
    }

    private void refreshTrapList(Trap newTrap, int newTrapPos) {
        int len = trapList.size();

        for (int i = 0; i < len - 1; i++) {
            trapList.get(i).setShape(trapList.get(i + 1).getShape());
            trapList.get(i).setTriangleDirection(trapList.get(i + 1).getTriangleDirection());
        }

        trapList.get(len - 1).setShape(Trap.PLAIN);

        trapList.get(newTrapPos).setShape(newTrap.getShape());
        trapList.get(newTrapPos).setTriangleDirection(newTrap.getTriangleDirection());
    }

}
