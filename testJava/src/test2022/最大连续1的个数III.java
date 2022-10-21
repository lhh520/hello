package test2022;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 最大连续1的个数III {
    @Test
    public void test(int n,int k) {
        Deque<Integer>deque=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            deque.add(i+1);
        }
        int cnt=1;
        while (deque.size()>1){
            if(cnt%k==0){
                deque.poll();
            }else {
                deque.offer(deque.poll());
            }
            cnt++;
        }
        System.out.println(deque.poll());
    }
}
