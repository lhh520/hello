package dp;

import java.util.ArrayList;
import java.util.List;

//public class ssgs {
//    static int N=15;
//    static int[][]f=new int[N][N];
//    static void init()
//    {
//        for(int i=0;i<=9;i++) f[1][i]=1;
//        for(int i=2;i<N;i++)
//            for(int j=0;j<=9;j++)
//                for(int k=j;k<=9;k++)
//                    f[i][j] += f[i-1][k];
//    }
//    static int dp(int n)
//    {
//        if(n<=0) return 1;
//        //vector<int>nums;
//        List<Integer>nums=new ArrayList<>();
//        //while(n) nums.push_back(n%10),n/=10;
//        while (n>0){
//            nums.add(n);
//        }
//        int res = 0,last = 0;
//        for(int i=nums.size()-1;i>=0;i--)
//        {
//            int x = nums[i];
//            for(int j=last;j<x;j++)
//                res += f[i+1][j];
//            if(x<last) break;
//            last = x;
//            if(!i) res ++;
//        }
//        return res;
//    }
//}
