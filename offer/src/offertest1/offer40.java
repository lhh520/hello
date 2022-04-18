package offertest1;

import java.util.Arrays;

public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[]ans=new int[k];
        for(int i=0;i<arr.length;i++){
           ans[i]=arr[i];
        }
        return ans;
    }
}
