package offertest1;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class offer49 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long>priorityQueue=new PriorityQueue<>();
        Set<Long>set=new HashSet<>();
        int[]factors=new int[]{ 2,3,5};
        set.add(1L);
        int ugly=0;
        priorityQueue.add(1L);
        for(int i=0;i<n;i++){
            long heap=priorityQueue.poll();
            ugly=(int)heap;
            for(int factor:factors){
                long next=heap*factor;
                if(set.add(next)){
                    priorityQueue.add(next);
                }
            }
        }
        return ugly;
    }
    @Test
    public void test(){
        int n=10;
        System.out.println(nthUglyNumber(n));
    }
}
