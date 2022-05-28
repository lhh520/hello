package testproject;

import org.junit.Test;

public class 下一个更大的数值平衡数 {
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<Integer.MAX_VALUE;i++){
            int[]nums=new int[10];
            //进行分解
            int temp=i;
            while (temp!=0){
                int cur=temp%10;
                nums[cur]++;
                temp=temp/10;
            }
            boolean flag=true;
            for(int j=0;j<10;j++){
                if(nums[j]!=0&&nums[j]!=j){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        System.out.println(nextBeautifulNumber(1));
    }
}
