package baidu;

import java.util.Arrays;
import java.util.Scanner;

public class test02 {
    //2
    //5
    //1 2 3 4 5
    //5
    //2 1 5 3 4
    public static void main(String[] args) {
//        int[]nums=new int[]{1,2,3,4,5};
//        System.out.println(getFlag(nums));
        Scanner sc=new Scanner(System.in);
        String s0=sc.nextLine();
        int total=Integer.parseInt(s0);
        for(int i=0;i<total;i++){
            String s=sc.nextLine();
            int t=Integer.parseInt(s);
            if(t>20){
                System.out.println(0);
                System.exit(0);
            }
            String s1=sc.nextLine();
            String[]ss2=s1.split(" ");
            int[]nums=new int[ss2.length];
            for(int ii=0;ii<nums.length;ii++){
                nums[ii]=Integer.parseInt(ss2[ii]);
            }
            //System.out.println(Arrays.toString(nums));
            System.out.println(getNums1(nums,nums.length));
        }
    }
    public static int getNums(int[]nums,int n){
        int[][]dp=new int[n][n];//表示i-j区间内的数据
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                dp[i][i]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                dp[i][j]=dp[i][j-1];
            }
        }
        return 1;
    }
    public static int getNums1(int[]nums,int n){
        int num=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<=n;j++){
               int[]newNum=new int[j-i];
               for(int k=i;k<j;k++){
                   newNum[k-i]=nums[k];
               }
               Arrays.sort(newNum);
                //System.out.println(Arrays.toString(newNum));
                if(newNum.length>0&&getFlag(newNum)){
                    num++;
                }
            }
        }
        return num;
    }
    public static boolean getFlag(int[]nums){
        int i=1;
        for(int ii=0;ii<nums.length;ii++){
            if(nums[ii]!=i){
                return false;
            }
            i++;
        }
        return true;
    }

}
