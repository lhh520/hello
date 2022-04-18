package test;

public class test152 {
    public int maxProduct(int[] nums) {
    int length=nums.length;
    int[] maxF=new int[length];
    int[] minF=new int[length];
    System.arraycopy(nums,0,maxF,0,length);
    System.arraycopy(nums,0,minF,0,length);
        for (int i = 0; i < length; i++) {
            maxF[i]=Math.max(maxF[i-1]*nums[i],Math.max(nums[i],minF[i-1]*nums[i]));
            minF[i]=Math.min(minF[i-1]*nums[i],Math.min(nums[i],maxF[i-1]*nums[i]));
        }
        int ans=maxF[0];
        for(int i=1;i<length;i++)
            ans=Math.max(ans,maxF[i]);
        return ans;
    }
    //
    public int maxProduct1(int[] nums)
    {
        int imax=1;
        int imin=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.max(imin*nums[i],nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }
}
