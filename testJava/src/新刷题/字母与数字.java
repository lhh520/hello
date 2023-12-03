package 新刷题;

import com.sun.tools.javac.comp.Enter;
import org.junit.Test;

import java.util.*;

public class 字母与数字 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String>set=new HashSet<>();
        int count=0;
        for(String word:words){
            if (set.contains(reverse2(word))){
                count++;
            }
            set.add(word);
        }
        return count;
    }
    private  String reverse2(String str) {
        if (str == null) {
            return null;
        }
        String result = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result = result + chars[i];
        }
        return result;
    }
    public int maxSum(int[] nums) {
        int ans=0;
        //0-9 共10个数字 用一个Map<Integer,List>
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int max=0;
            int curNum=nums[i];
            while (curNum>0){
                int cur=curNum%10;
                max=Math.max(max,cur);
                curNum=curNum/10;
            }
            List<Integer>list=map.getOrDefault(max,new ArrayList<>());
            list.add(nums[i]);
            map.put(max,list);
        }
        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            if (entry.getValue().size()<2){
                continue;
            }
            List<Integer>list=entry.getValue();
            Collections.sort(list);
            ans=Math.max(ans,list.get(list.size()-1)+list.get(list.size()-2));
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{51,71,17,24,42};
        System.out.println(maxSum(nums));
    }

}
