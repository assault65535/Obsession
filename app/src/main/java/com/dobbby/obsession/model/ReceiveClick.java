package com.dobbby.obsession.model;

/**
 * Created by Dobbby on 16/7/5.
 */
public class ReceiveClick implements IReceiveClick {

    @Override
    public void judgeClick(final int clickPos, final OnUserClickListener listener) {

        // 错误点击暂时用0代替, 正确点击暂时用1代替, 到时候再改 ...
        new Thread(new Runnable() {
            public void run() {
                if (clickPos == 0) {
                    listener.wrongClick();
                } else if (clickPos == 1) {
                    listener.rightClick();
                }
            }
        }).start();
    }
}
