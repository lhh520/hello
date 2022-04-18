package offer;

import org.junit.Test;

import java.util.*;

public class offer070 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //PriorityQueue<Integer>priorityQueue=new PriorityQueue<>(k);
        List<Integer>cur=new ArrayList<>();
        List<Integer>key=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry: map.entrySet())
        {   int key1=entry.getKey();
            int temp=entry.getValue();
            cur.add(temp);
            key.add(key1);
        }
        //System.out.println(8);
        for(int i=0;i<cur.size()-1;i++)
        {
            for(int j=i+1;j<cur.size();j++)
            {
                if(cur.get(i)<cur.get(j))
                {
                    int temp=cur.get(i);
                    cur.set(i,cur.get(j));
                    cur.set(j,temp);
                    //Collections.replaceAll(cur,cur.get(i),cur.get(j));
                    //Collections.replaceAll(cur,cur.get(j),temp);
                    int temp1=key.get(i);
                    //Collections.replaceAll(key,key.get(i),key.get(j));
                    //Collections.replaceAll(key,key.get(j),temp1);
                    key.set(i,key.get(j));
                    key.set(j,temp1);
                }
            }
        }
        //System.out.println(9);
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=key.get(i);
        }
        return ans;
    }

    @Test
    public void test()
    {
        //nums = [1,1,1,2,2,3], k = 2
        int[] nums=new int[]{1,1,1,2,2,3};
        int k=2;
        int[] ans=topKFrequent(nums,k);
        System.out.println(Arrays.toString(ans));
    }
}
