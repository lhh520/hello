package nums;

public class yy {
    private static void QuickSort(int[]nums,int left,int right){
        if(left>right){
            return;
        }
        int left0=left;
        int right0=right;
        int baseNum=nums[left];
        while (left!=right){
            while (nums[right]>=baseNum&&left<right){
                right--;
            }
            while (nums[left]<=baseNum&&left<right){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            QuickSort(nums,left0,left-1);
            QuickSort(nums,right+1,right0);
        }
    }
}
