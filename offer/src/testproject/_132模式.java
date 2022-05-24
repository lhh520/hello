package testproject;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _132模式 {
    public boolean find132pattern(int[] nums) {
        boolean flag1=false;
        boolean flag2=false;
        for(int i=1;i<nums.length-1;i++){
            //向两边扩散
            int left=i-1,right=i+1;
            while (left>=0){
                if(nums[left]<nums[i]){
                    flag1=true;
                    break;
                }
                left--;
            }
            //
            while (right<nums.length){
                if(nums[right]<nums[i]){
                    flag2=true;
                    break;
                }
                right++;
            }
            if(flag1&&flag2){
                return true;
            }
        }
        return false;
    }

    public boolean find132pattern1(int[] nums){
        int n=nums.length;
        Deque<Integer>d=new ArrayDeque<>();
        int k=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<k) return true;
            while (!d.isEmpty()&&d.peekLast()<nums[i]){
                k=Math.max(k,d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
    public boolean find132pattern12(int[] nums){
        int n=nums.length;
        Stack<Integer>stack=new Stack<>();
        int k=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<k) return true;
            while (!stack.isEmpty()&&nums[i]>stack.peek()){
                k=Math.max(k,stack.pop());
            }
            stack.add(nums[i]);
        }
        return false;
    }
    @Test
    public void test(){
        int[]nums=new int[]{-1,3,2,0};
        System.out.println(find132pattern(nums));
    }
}
