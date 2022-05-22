package testproject;

import org.junit.Test;

import java.util.Map;

public class 有界数组中指定下标处的最大值 {
    public int maxValue(int n, int index, int maxSum) {
        //从中间相两边扩散
        int l=index,r=index;
        int ans=1;
        int rest=maxSum-n;//先全填充为1
        while (l>0||r<n-1){
            int len=r-l+1;//中间的长度
            if(rest>=len){
                //[l,r]范围全部+1
                rest-=len;
                ans++;
                l=Math.max(0,l-1);
                r=Math.min(r+1,n-1);
            }else {
                break;
            }
        }
        ans+=rest/n;
        return ans;
    }
    @Test
    public void test(){
        int n = 4, index = 2,  maxSum = 6;
        System.out.println(maxValue(n,index,maxSum));
    }
}
