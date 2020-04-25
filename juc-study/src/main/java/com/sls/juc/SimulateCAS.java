package com.sls.juc;

public class SimulateCAS {



    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    boolean compare = compareAndSwap.compare(compareAndSwap.getVal(), (int) Math.random() * 101);
                    System.out.println(compare);

                }
            }).start();
        }
    }

}

class CompareAndSwap{

    private int a ;

    //获取内存值
   public synchronized int getVal(){
       return  a ;
    }

    //比较值
    private synchronized int compareAndSet(int expectedVal,int newVal){
        int oldVal = a;
        if(oldVal == expectedVal){
            this.a = newVal;
        }
        return oldVal;
    }

    public synchronized boolean compare(int expectedVal,int newVal){
        return expectedVal == compareAndSet(expectedVal,newVal);
    }
}