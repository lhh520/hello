public class test992 {
    public int[] sortArrayByParityII(int[] nums) {
    int[] a=new int[nums.length/2];
    int[] b=new int[nums.length/2];
    int j=0,k=0;
    for(int i=0;i<nums.length;i++)
    {
        if(nums[i]%2==0)
        {a[j]=nums[i];
         j++;
        }
        else
        {
            b[k]=nums[i];
            k++;
        }
    }
    j=0;
    k=0;
    for(int i=0;i<nums.length;i++)
    {
        if(i%2==0)
        {
            nums[i]=a[j];
            j++;
        }
        else
        {
            nums[i]=b[k];
            k++;
        }
    }
    return nums;
    }
}
