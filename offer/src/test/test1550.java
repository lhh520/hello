package test;

import org.junit.Test;

public class test1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
    //int left=0,right=arr.length;
        int count=0;
    for (int left=0;left<arr.length;left++)
    {

        if (arr[left]%2==1)
        {
            count++;
            if(count>=3)
                return true;
        }
        else
            count=0;


    }
    return false;
    }
    @Test
    public void test()
    {
        int[] arr=new int[]{2,6,4,1,3,5};
        System.out.println(threeConsecutiveOdds(arr));
    }
}
