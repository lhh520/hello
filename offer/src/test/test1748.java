package test;

import java.util.HashMap;
import java.util.Map;

public class test1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int sum=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
            if(entry.getValue()==1)
                sum+= entry.getKey();
        }
        return sum;
    }
    public int nearestValidPoint(int x, int y, int[][] points) {
        int sum=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<points.length;i++)
        {
            int[]temp=points[i];
            if(temp[0]==x||temp[1]==y)
            {  System.out.println(temp[0]+".  "+temp[1]);
                int ab=Math.abs(temp[0]-x) + Math.abs(temp[1]-y);
                if(ab<sum)
                {
                    ans=i;
                    sum=ab;
                }
            }
        }
        return ans;
    }
}
