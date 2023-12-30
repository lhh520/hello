package 新刷题;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //
        int[]nums3=new int[m];
        for(int i=0;i<m;i++){
            nums3[i]=nums1[i];
        }
        int ii=0,jj=0,tt=0;
        while (ii<m||jj<n){
            int nums00=ii>=m?Integer.MAX_VALUE:nums3[ii];
            int nums01=jj>=n?Integer.MAX_VALUE:nums2[jj];
            if(nums00<=nums01){
                nums1[tt++]=nums00;
                ii++;
            }else {
                nums1[tt++]=nums01;
                jj++;
            }
        }

    }
    @Test
    public void test(){
        int[]nums1=new int[]{1,2,3,0,0,0};
        int[]nums2=new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
