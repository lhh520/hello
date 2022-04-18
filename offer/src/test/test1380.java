package test;

import java.util.ArrayList;
import java.util.List;

public class test1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer>temp=new ArrayList<>();
        List<Integer>temp1=new ArrayList<>();
    for(int i=0;i<matrix.length;i++)
    {
       int templ=findMin(matrix[i]);
       temp.add(templ);
    }
        for(int i=0;i<matrix[0].length;i++)
        {   int[] te=new int[matrix.length];
            for(int j=0;j<matrix.length;j++)
            {
                te[j]=matrix[j][i];
            }
            int temp2=findMax(te);
            temp1.add(temp2);
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<temp.size();i++)
        {
            if(temp1.contains(temp.get(i)))
                ans.add(temp.get(i));
        }
        return ans;
    }
    int findMin(int[] nums)
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            min=Math.min(min,nums[i]);
        }
        return min;
    }
    int findMax(int[] nums)
    {
        int min=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            min=Math.max(min,nums[i]);
        }
        return min;
    }
}
