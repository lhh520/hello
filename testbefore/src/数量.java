import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 数量 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(map.containsKey(need)){
                return new int[]{i,map.get(need)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int maxLen=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            maxLen=Math.max(maxLen,s.length());
            while (!set.isEmpty()&&set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
        }
        return maxLen;
    }
    @Test
    public void test(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
