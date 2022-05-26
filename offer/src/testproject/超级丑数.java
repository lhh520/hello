package testproject;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 超级丑数 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long>queue=new PriorityQueue<>();
        Set<Long> set=new HashSet<>();
        int[]factors=new int[]{2,3,5};
        set.add(1L);
        queue.add(1L);
        int ugly=0;
        for(int i=0;i<n;i++){
            long curr=queue.poll();
            ugly=(int)curr;
            for(int factor:factors){
                long next=curr*factor;
                if(set.add(next)){
                    queue.add(next);
                }
            }
        }
        return ugly;
    }
    //
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long>queue=new PriorityQueue<>();
        Set<Long> set=new HashSet<>();
        int[]factors=primes;
        set.add(1L);
        queue.add(1L);
        int ugly=0;
        for(int i=0;i<n;i++){
            long curr=queue.poll();
            ugly=(int)curr;
            for(int factor:factors){
                long next=curr*factor;
                if(set.add(next)){
                    queue.add(next);
                }
            }
        }
        return ugly;
    }
    @Test
    public void test(){
        int[]primes=new int[]{2,7,13,19};
        System.out.println(nthSuperUglyNumber(12,primes));
    }
}
