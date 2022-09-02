package edu.itstudy.util;

import java.util.Random;

public class RandomUtil {
    public static int getRandomInt(){
long time=System.currentTimeMillis();
        String temp = (time + "").substring(7);
        Random r=new Random();
        int i=r.nextInt(100);
        temp+=i;
        return Integer.parseInt(temp);
    }
}
