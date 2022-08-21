package hot100;

import org.junit.Test;

import java.util.*;

public class 下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len=nums2.length;
        int[]ret=new int[len];
        Arrays.fill(ret,-1);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        Stack<Integer>stack=new Stack<>();
        stack.push(0);
        for(int i=0;i<len;i++){
            if(nums2[i]<=nums2[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                    ret[stack.peek()]=nums2[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        int[]ans=new int[nums1.length];
        //
        for(int i=0;i<nums1.length;i++){
            ans[i]=ret[map.get(nums1[i])];
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{4,1,2};
        int[]nums2 =new int[]{1,3,4,2};
        int[]ret=nextGreaterElement(nums,nums2);
        System.out.println(Arrays.toString(ret));
    }
}
