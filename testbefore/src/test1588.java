import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test1588 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    int sum=0;
    public int sumOddLengthSubarrays(int[] arr) {
        int len=arr.length;
        System.out.println("j");

         dfs(arr,0,len);
         return sum;
    }
    public void dfs(int[] arr,int index,int len)
    {   if(index==len)
       {   int nn=list.size();
           if(nn%2!=0)
           {
               sum=sum+summ(new ArrayList<>(list));
           }
           return;
       }
        dfs(arr,index+1,len);
        list.add(arr[index]);
        dfs(arr,index+1,len);
        list.remove(list.size()-1);
    }
    public int summ(List<Integer>list)
    {   int sum1=0;
        System.out.println(list);
        for(int i=0;i<list.size();i++)
        {
            sum1=sum1+list.get(i);
        }
        System.out.println(sum1);
        return sum1;
    }
    @Test
    public void test()
    {
        int[] arr=new int[]{1,4,2,5,3};
        int ans=sumOddLengthSubarrays(arr);
        System.out.println(ans);
    }
    public int sumOddLengthSubarrays1(int[] arr) {
        int sum=0;
        int n=arr.length;
        for(int start=0;start<n;start++)
        {
            for(int length=1;start+length<=n;length+=2)
            {
                int end=start+length-1;
                for(int i=start;i<=end;i++)
                    sum=sum+arr[i];
            }
        }
        return sum;
    }
    //
    public int sumOddLengthSubarrays2(int[] arr)
    {
        int n=arr.length;
        int[]presum=new int[n+1];
        for(int i=0;i<n;i++)
        {
            presum[i+1]=presum[i]+arr[i];
        }
        for(int start=0;start<n;start++)
        {
            for(int length=1;start+length<=n;length+=2)
            {
                int end=start+length-1;
               sum+=presum[end+1]-presum[start];
            }
        }
        return sum;
    }
}
