import java.util.HashMap;
import java.util.Map;

public class test137
{
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet())
        {
                int num=entry.getKey(),occ=entry.getValue();
                if(occ==1)
                {
                    ans=num;
                    break;
                }
        }
        return ans;
    }
}
