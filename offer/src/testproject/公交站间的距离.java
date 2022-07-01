package testproject;

import org.junit.Test;

public class 公交站间的距离 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       int a=Math.min(start,destination);
       int b=Math.max(start,destination);
       int tx1=0;
       for(int i=a;i<b;i++){
           tx1+=distance[i];
       }
       int tx2=0;
        for(int i=b;i<distance.length;i++){
            tx2+=distance[i];
        }
        for(int i=0;i<a;i++){
            tx2+=distance[i];
        }
        System.out.println(tx2);
       return Math.min(tx1,tx2);
    }
    @Test
    public void test(){
        int[]distance =new int[]{1,2,3,4};
        int start = 0, destination = 1;
        System.out.println(distanceBetweenBusStops(distance,start,destination));
    }
}
