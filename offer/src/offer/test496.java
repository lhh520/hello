package offer;

import org.junit.Test;

import java.util.Arrays;

public class test496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i=0;i<ans.length;i++)
        {
            ans[i]=-1;
        }
        //Arrays.sort(nums2);
        //System.out.println(9);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums2[j] == nums1[i]) {
                    for(int k=j;k<nums2.length;k++)
                    {
                        if(nums2[k]>nums1[i])
                        {
                            ans[i]=nums2[k];
                            nums1[i]=Integer.MIN_VALUE;
                            break;
                        }
                    }
                }
                //ans[i]=-1;
            }
        }
        return ans;
    }

    @Test
    public void test()
    {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{1,3,4,2};
        int[] ans=nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
}
