package com.jary.progress.juc.thread.sync;

/**
 * @author fanzhengjie
 * @create 2019/10/23 下午11:58
 * @description 脏读
 */
public class PublicVar {

    private String userName = "A";
    private String pass = "AA";

    public synchronized void setValue(String userName, String pass) {

        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.pass = pass;

            System.out.println("setValue method thread name="
                + Thread.currentThread().getName() + " username="
                + userName + " password=" + pass);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * //该方法前加上synchronized关键字就同步了
     */
    public void getValue() {
        System.out.println("getValue method thread name="
            + Thread.currentThread().getName() + " username=" + userName
            + " password=" + pass);
    }


}
