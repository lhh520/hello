package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class offer49 {
    public int nthUglyNumber(int n)
    {
        Set<Long>set=new HashSet<>();
        PriorityQueue<Long>heap=new PriorityQueue<>();
        int[] factors={2,3,5};
        set.add(1L);
        heap.add(1L);
        int ugly=0;
        for(int i=0;i<n;i++)
        {
            long temp=heap.poll();
            ugly=(int)temp;
            for(int factor:factors)
            {
                long next=temp*factor;
                if(set.add(next))
                    heap.add(next);
            }
        }
        return ugly;
    }
}
