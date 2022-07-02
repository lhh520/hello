package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的k个最强值 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int m=arr[(n-1)/2];
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a=Math.abs(o1-m);
                int b=Math.abs(o2-m);
                if(a==b){
                    return o2-o1;
                }else {
                    return b-a;
                }
            }
        });
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int[]nums=new int[k];
        for(int i=0;i<k;i++){
            nums[i]=pq.poll();
        }
        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        return nums;
    }
    @Test
    public void test(){
        int[]arr=new int[]{1,2,3,4,5};
        int[]ss=getStrongest(arr,2);
        System.out.println(Arrays.toString(ss));
    }
}
