package 热题100;

import org.junit.Test;

import java.util.Arrays;

public class 二进制字符串前缀一致的次数 {
    public int numTimesAllBlue(int[] flips) {
        //找到一个数字 前面都是大于自己的 后面也是大于自己的
        int len=flips.length;
        int[]left=new int[len];
        int[]right=new int[len];
        int min=Integer.MAX_VALUE;
        left[0]=min;
        for(int i=1;i<flips.length;i++){
            min=Math.min(flips[i-1],min);
            left[i]=min;
        }
        System.out.println(Arrays.toString(left));
        min=Integer.MAX_VALUE;
        right[len-1]=min;
        for(int i=flips.length-2;i>=0;i--){
            min=Math.min(flips[i+1],min);
            right[i]=min;
        }
        System.out.println(Arrays.toString(right));
        int count=0;
        for(int i=0;i<len;i++){
            if((left[i]>flips[i]&&right[i]>flips[i])){
                System.out.println(i);
                count++;
            }
        }
        if(flips[0]==1){
            count++;
        }
        if(flips[len-1]==len){
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        int[]flips =new int[]{3,2,4,1,5};
        System.out.println(numTimesAllBlue(flips));
    }
}
