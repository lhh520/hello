package testproject;

import org.junit.Test;

public class 爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int k=0;k<piles.length;k++){
            max=Math.max(max,piles[k]);
        }
        int low=1,high=max;
        int ans=0;
        while (low<=high){
            int speed=low+(high-low)/2;//二分法获取speed
            long time=getTime(piles,speed);
            if(time<=h){
                ans=speed;
                high=speed-1;
            }else {
                low=speed+1;
            }
        }
        return ans;
    }

    public long getTime(int[] piles, int speed){
        long time=0;
        for(int j=0;j<piles.length;j++){
            time+=piles[j]/speed;
            if(piles[j]%speed!=0){
                time++;
            }
        }
        return time;
    }

    @Test
    public void test(){
        //[30,11,23,4,20]
        //5
        int[]piles =new int[]{30,11,23,4,20};;
        int h = 5;
        System.out.println(minEatingSpeed(piles,h));
    }
}
