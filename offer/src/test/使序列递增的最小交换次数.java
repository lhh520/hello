package test;

public class 使序列递增的最小交换次数 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int[][]f=new int[n][2];
        f[0][0]=0;//表示0 不需要交换
        f[0][1]=1;
        for(int i=1;i<nums1.length;i++){
            if(nums1[i-1]<nums1[i]&&nums2[i-1]<nums2[i]){//此时双方都有序
                //1.如果不交叉
                if(nums1[i-1]<nums2[i]&&nums2[i-1]<nums1[i]){
                    f[i][0]=Math.min(f[i-1][0],f[i-1][1]);
                    f[i][1]=Math.min(f[i-1][0],f[i-1][1])+1;
                }else {
                    f[i][0]=f[i-1][0];
                    f[i][1]=f[i-1][1]+1;
                }
            }else {
                f[i][0]=f[i-1][1];
                f[i][1]=f[i-1][0]+1;
            }
        }
        return Math.min(f[f.length-1][0],f[f.length-1][1]);
    }
}
