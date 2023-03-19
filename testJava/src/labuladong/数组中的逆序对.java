package labuladong;

public class 数组中的逆序对 {
    int count=0;
    int[]temp;
    public int reversePairs(int[] nums) {
        int len=nums.length;
        if(nums.length<=0){
            return 0;
        }
        temp=new int[len];
        sort(nums,0,len-1);
        return count;
    }
    private void sort(int[]nums,int lo,int hi){
        if(lo==hi) return;
        int mid=(lo+hi)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    private void merge(int[]nums,int lo,int mid,int hi){
        for(int i=0;i<=hi;i++){
            temp[i]=nums[i];
        }
        int cnt=lo;
        int i=lo,j=mid+1;
        while (i<=mid||j<=hi){
            if(i>mid) nums[cnt++]=temp[j++];
            else if(j>hi) nums[cnt++]=temp[i++];
            else if(temp[i]<=temp[j]) nums[cnt++]=temp[i++];
            else {
                count+=(mid-i+1);
                nums[cnt++]=temp[j++];
            }
        }
    }
}
