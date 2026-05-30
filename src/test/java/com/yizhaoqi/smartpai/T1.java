package com.yizhaoqi.smartpai;

public class T1 {
    public static void main(String[] args) {
        String s1 = "abc";
        String intern = s1.intern();
        String s3 = "abc";
        System.out.println(s1==intern);//false
        System.out.println(s1==s3);//false
        System.out.println(intern==s3);//true
        for (int i = 0; i < 10000; i++) {
            new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    new Thread(()->{}).start();
                }
            }).start();
        }

    }

    public static int test1(int value){
        try{
            return value*value;
        }catch (Exception e){

        }finally {
            if (value==2) {
                return value;
            }
        }
        return 1;
    }
}
