package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class 下一个更大的元素 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<Integer>();
        int n=nums1.length;
        int[]result=new int[n];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums1[i],i);
        }
        stack.push(0);
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]<=nums2[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                    if(map.containsKey(nums2[stack.peek()])){
                        Integer index=map.get(nums2[stack.peek()]);
                        result[index]=nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
    @Test
    public void test(){
        int[]nums1=new int[]{4,1,2};
        int[]nums2=new int[]{1,3,4,2};
        int[]nums=nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(nums));
    }
}
