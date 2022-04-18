import org.junit.Test;

public class test496
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {   int j=0;
            while(nums2[j]!=nums1[i])
                j++;
            int k=0;
            j++;
            for(k=j;k<nums2.length;k++)
            {
                if(nums2[k]>nums1[i])
                {nums[i]=nums2[k];
                break;}
            }
            if(k== nums2.length)
            {
                nums[i]=-1;

            }
        }
        //System.out.println(nums.toString());
        return nums;
    }
   //nums1 = [4,1,2], nums2 = [1,3,4,2].
    @Test
    public void test()
    {
        int[] nums1=new int[]{4,1,2};
        int[] nums2=new int[]{1,3,4,2};
        int[] ans=nextGreaterElement(nums1,nums2);
        System.out.println(ans.toString());
    }
}
