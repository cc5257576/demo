package com.cc.common.test;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2020/5/7 11:59
 * Description:
 */
public class Child extends Father {

    public static int max = 50;
    private static int i = 0;
    private static Object o = new Object();

    public static void main(String[] args) {
        lock();
//        while (i<max){
//            lock();
//            try{
//                Thread.sleep(100);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }

    public static void lock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<max){
                    synchronized (o){
                        if((i%2)==1){
                            try{
                                o.wait();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }else{
                            System.out.println(i + ": A");
                            i++;
                            o.notifyAll();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<max){
                    synchronized (o) {
                        if((i%2)==0){
                            try{
                                o.wait();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }else{
                            System.out.println(i + ": B");
                            i++;
                            o.notifyAll();
                        }
                    }
                }
            }
        }).start();

    }
}
