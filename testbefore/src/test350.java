import org.junit.Test;

import java.util.Arrays;

public class test350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans=new int[Math.min(nums1.length,nums2.length)];
        int i=0,j=0,k=0;
        //System.out.println("he");
        while(i!=nums1.length&&j!=nums2.length)
        {
            if(nums1[i]==nums2[j])
            {ans[k]=nums1[i];
             i++;
             j++;
             k++;
             continue;
            }
            if(i!=nums1.length&&j!=nums2.length&&nums1[i]<nums2[j])
            {
                i++;
                continue;
            }
            if(i!=nums1.length&&j!=nums2.length&&nums1[i]>nums2[j])
            {
                j++;
                continue;
            }
        }
        //System.out.println(Arrays.toString(ans));
        int[]anss=new int[k];
        for(int ii=0;ii<k;ii++)
        {
            anss[ii]=ans[ii];
        }
        return anss;
    }
    @Test
    public void test()
    {   //[4,9,5]
//[9,4,9,8,4]
        //n ums1 = [1,2,2,1], nums2 = [2,2]
        int[] nums1=new int[]{4,9,5};
        int[] nums2=new int[]{9,4,9,8,4};
        int[] ans=intersect(nums1,nums2);
        System.out.println(Arrays.toString(ans));

    }
}
