package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 距离相等的条形码 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int max=0;
        for(int i=0;i< barcodes.length;i++){
            max=Math.max(max,barcodes[i]);
        }
        int[]nums=new int[max+1];
        for(int i=0;i< barcodes.length;i++){
            nums[barcodes[i]]++;
        }
        int count=0;
        int index=0;
        for(int i=0;i<=max;i++){
            if(nums[i]>count){
                count=nums[i];
                index=i;
            }
        }
        System.out.println(count);
        int[]ans=new int[barcodes.length];
        int k=0;
        for(k=0;k< barcodes.length;k=k+2){
            ans[k]=index;
            count--;
            if(count==0){
                break;
            }
        }
        //开始遍历之后的
        int m=0;
        while (m<=max){
            if(m==index){
                m++;
                continue;
            }
            if(nums[m]>0)
            for(int j=0;j<nums[m];j++){
                k=k+2;
                if(k>=barcodes.length){
                    k=1;
                }
                ans[k]=m;

            }
            m++;

        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    @Test
    public void test(){
        int[] barcodes=new int[]{1,1,1,1,2,2,3,3};
        rearrangeBarcodes(barcodes);
    }
}
