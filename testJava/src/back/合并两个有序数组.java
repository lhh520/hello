package back;

import org.junit.Test;

import java.util.Arrays;

public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]nums=new int[m+n];
        int ii=0,jj=0;
        int index=0;
        while (ii<m||jj<n){
            int t1=ii>=m?Integer.MAX_VALUE:nums1[ii];
            int t2=jj>=n?Integer.MAX_VALUE:nums2[jj];
            if(t1<t2){
                nums[index++]=t1;
                ii++;
            }else {
                nums[index++]=t2;
                jj++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<m+n;i++){
            nums1[i]=nums[i];
        }

    }
    @Test
    public void test(){
        int[]nums1 =new int[]{1,2,3,0,0,0};
        int m = 3,  n = 3;
        int[]nums2 =new int[]{2,5,6};
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
