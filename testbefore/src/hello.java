import org.junit.Test;

import java.util.*;

public class hello
{
    public int peakIndexInMountainArray(int[] arr) {
    for(int i=0;i<arr.length-1;i++)
    {
        if(arr[i]>arr[i+1])
            return i;
    }
    return -1;
    }
    @Test
    public void test()
    {
        //A = [1,2,3,0,0,0], m = 3


    }
}
