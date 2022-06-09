package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 数据流中的第K大元素 {
    int k;
    PriorityQueue<Integer>pq;
    public 数据流中的第K大元素(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int i=0;i< nums.length;i++){
            pq.add(nums[i]);
        }
        System.out.println(pq.peek());
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[]nums=new int[]{4, 5, 8, 2};
        数据流中的第K大元素 oo=new 数据流中的第K大元素(3,nums);
        System.out.println(oo.add(3));
        System.out.println(oo.add(1));
    }
}
