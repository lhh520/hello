import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]>temp=new ArrayList<int[]>();
        int sum,r=2,l=1;
        while(r<(target/2+1))
        {
            sum=(r+l)*(r-l+1)/2;
            if(sum==target)
            {   int[] tt=new int[r-l+1];
                for(int i=l;i<r-l+1;i++)
                {
                    tt[i]=i;
                }
                temp.add(tt);
                l++;
            }
            if(sum<target)
                r++;
            if(sum>target)
                l++;
        }
         return temp.toArray(new int[temp.size()][]);
    }
    @Test
    public void test()
    {
        int target=9;
        System.out.println(Arrays.toString(findContinuousSequence(target)));
    }
}
