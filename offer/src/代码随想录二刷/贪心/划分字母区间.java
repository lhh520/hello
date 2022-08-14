package 代码随想录二刷.贪心;
import org.junit.Test;

import java.util.*;
public class 划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        //先遍历字符串，找到出现数字出现的最后一个位置
        int[]nums=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            nums[c-'a']=i;//获得了最远的存储的数字
        }
        System.out.println(Arrays.toString(nums));
        int max=0,left=0;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
             max=Math.max(max,nums[c-'a']);
             if(i==max){
                list.add(max-left+1);
                left=i+1;
             }
        }
        return list;
    }
    @Test
    public void test(){
        String S = "ababcbacadefegdehijhklij";
        List<Integer>list=partitionLabels(S);
        System.out.println(list.toString());
    }
}
