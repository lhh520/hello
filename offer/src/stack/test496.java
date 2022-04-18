package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class test496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>temp=new Stack<>();
        int[]res=new int[nums1.length];
        Arrays.fill(res,-1);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        temp.add(0);
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]<=nums2[temp.peek()]){//如果小于，则直接加入
                temp.add(i);
            }else {
                while (!temp.isEmpty()&&nums2[i]>nums2[temp.peek()]){
                   if(map.containsKey(nums2[temp.peek()])){
                       Integer index=map.get(nums2[temp.peek()]);
                       res[index]=nums2[i];
                   }
                   temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }
    public int[] nextGreaterElement1(int[] nums1, int[] nums2){
        int len=nums1.length;
        int[]res=new int[len];
        Arrays.fill(res,-1);
        Stack<Integer>stack=new Stack<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(nums1[i],i);
        }
        stack.add(0);
        for(int i=1;i<nums2.length;i++){
            if(nums2[i]<=stack.peek()){
                stack.add(i);
            }else {
                while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                    if(map.containsKey(nums2[stack.peek()])){
                    Integer index=map.get(nums2[stack.peek()]);
                    res[index]=nums2[i];
                    }
                    stack.pop();
                }
                stack.add(i);
            }
        }
        return res;
    }
}
