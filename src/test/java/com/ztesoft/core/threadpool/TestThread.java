/**
 * 
 */
package com.ztesoft.core.threadpool;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月13日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.threadpool <br>
 */

public class TestThread extends Thread {

    private  int i;

    private User user;

    private ThreadLocal<Integer> tl = new ThreadLocal<Integer>();;

    public TestThread(int i, String name) {
        this.i = i;
        tl.set(i);
        this.user = new User(name, i);
        System.out.println("构造函数，线程i=" + i + ",tl=" + this.tl.get() + ",user="
                + user);

    }

    @Override
    public void run() {
        try {
            Thread.sleep(Math.round(100));
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(int j=0;j<10;j++){
            i++;
        }
        System.out
                .println("run方法，                                            线程i="
                        + i + ",tl=" + this.tl.get() + ",user=" + user);
    }

    public class User {
        private String name;

        private int number;

        User(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String toString() {
            return "[" + this.name + "," + this.number + "]";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TestThread r = new TestThread(i, "name" + i);
            r.start();
            // Thread t = new Thread(r);
            // t.start();
        }

    }

}
