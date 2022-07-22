package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 雪糕的最大数量 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num=0;
        for(int i=0;i<costs.length;i++){
            if(coins<costs[i]){
                return num;
            }else {
                num+=1;
                coins-=costs[i];
            }
        }
        return costs.length;
    }
    @Test
    public void test(){
        int[]costs =new int[]{1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs,coins));
    }
}
