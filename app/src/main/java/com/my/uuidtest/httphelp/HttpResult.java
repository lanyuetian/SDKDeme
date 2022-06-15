package com.my.uuidtest.httphelp;

import com.my.uuidtest.AnnoTest;


/**
 * Create by ldd
 * 日期：2022/5/5
 */
public class HttpResult {

    @AnnoTest
    public void doCallBackSuc(ICallback iCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    iCallback.success(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    iCallback.failed();
                }
            }
        }).start();
    }

}