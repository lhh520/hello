package testproject;

import org.junit.Test;

import java.util.*;

public class 最大宽度坡 {
    public int maxWidthRamp(int[] nums) {
        //从右向左找最大值 从左往右找最大值
        int n=nums.length;
        //从左到右 从右到左
        int[]left=new int[n];
        int[]right=new int[n];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            left[i]=min;
            min=Math.min(min,nums[i]);

        }
        for(int i=n-1;i>=0;i--){
            right[i]=max;
            max=Math.max(max,nums[i]);

        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ret=Integer.MIN_VALUE;
        int len=-1;
        for(int i=0;i<n;i++){
            ret=Math.max(ret,right[i]-left[i]);
        }
        return ret;
    }
    public int maxWidthRamp1(int[] nums){//双指针
        int n=nums.length;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//记录的都是索引
                return nums[o1]-nums[o2];
            }
        });
        System.out.println(list.toString());
        int ansMax=0;
        int curMin=nums.length;
        for(int i=0;i<list.size();i++){//已经知道了相对的次序
            int curIndex=list.get(i);//获取当前的索引
            ansMax=Math.max(ansMax,curIndex-curMin);
            curMin=Math.min(curMin,curIndex);//是为了获取最小的索引
        }
        return ansMax;
    }
    //单调栈的方法：
    public int maxWidthRamp2(int[] nums){//单调栈
        Stack<Integer>stack=new Stack<>();
        int n=nums.length;
        int maxWidth=0;
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()||nums[stack.peek()]>nums[i]){//单调递减栈
                stack.push(i);
            }
        }
        for(int i=n-1;i>=0;i--){
            while (!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                int pos=stack.pop();
                maxWidth=Math.max(maxWidth,i-pos);
            }
        }
        return maxWidth;
    }

    @Test
    public void test(){
        int[]nums=new int[]{6,0,8,2,1,5};
        System.out.println(maxWidthRamp1(nums));
    }
}
