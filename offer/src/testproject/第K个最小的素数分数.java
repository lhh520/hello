package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 第K个最小的素数分数 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        for(int i=1;i<arr.length;i++){
             pq.add(new int[]{0,i});
        }
        for(int i=1;i<k;i++){
            int[]frac=pq.poll();
            int x=frac[0],y=frac[1];
            if(x+1<y){
                pq.offer(new int[]{x+1,y});
            }
        }
        int m1=pq.peek()[0];
        int m2=pq.peek()[1];
        return new int[]{arr[m1],arr[m2]};
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,2,3,5};
        int[] nn=kthSmallestPrimeFraction(nums,3);
        System.out.println(Arrays.toString(nn));
    }
}
