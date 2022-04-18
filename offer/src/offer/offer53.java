package offer;

public class offer53 {
    public int missingNumber(int[] nums) {
        //二分法进行遍历
    int i=0,j=nums.length-1;
    while (i<j){
        int m=(i+j)/2;
        if(nums[m]==m) i=m+1;
        else j=m-1;
    }
    return i;
    }
}
