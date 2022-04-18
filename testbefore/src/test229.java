import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test229 {
    //方法一：哈希表计数
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer>ans=new HashMap<Integer,Integer>();
        List<Integer>ret=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length;
        for(Map.Entry<Integer,Integer>entry: ans.entrySet())
        {
            int num=entry.getKey(),occ=entry.getValue();
            if(occ>=n/3)
              ret.add(new Integer(num));
        }
        return ret;
    }
    //摩尔投票法，时间复杂度为O(1)
    public List<Integer> majorityElement1(int[] nums)
    {
        List<Integer>res=new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        //初始化候选人，以及计票
        int cand1=nums[0],count1=0;
        int cand2=nums[0],count2=0;
        //摩尔投票
        for(int num:nums)
        {
            if(cand1==num)
            {
                count1++;
                continue;
            }
            if(cand2==num)
            {
                count2++;
                continue;
            }
            if(count1==0)
            {
                cand1=num;
                count1++;
                continue;
            }
            if(count2==0)
            {
                cand2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==cand1)
                count1++;
            if(nums[i]==count2)
                count2++;
            //if(co)
        }
        if(count1>nums.length/3)
            res.add(cand1);
        if(count2>nums.length/3)
            res.add(cand2);
        return res;
    }
}
