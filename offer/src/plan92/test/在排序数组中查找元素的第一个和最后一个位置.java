package plan92.test;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target){
        int len=nums.length;
        if(len==0){
            return new int[]{-1,-1};
        }
        int left=0,right=nums.length-1;
        int mid=0;
        while (left<=right){
             mid=(left+right)/2;
             if(nums[mid]==target){
                 break;
             }
            if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }

        if(nums[mid]!=target){
            return new int[]{-1,-1};
        }
        int i=mid;
        while (i>=0&&nums[i]==target){
            i--;
        }
        int j=mid;
        while (j<len&&nums[j]==target){
            j++;
        }
        return new int[]{i+1,j-1};
    }
}
