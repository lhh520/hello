package test;

import java.util.List;
//todo
public class test120 {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n=triangle.size();
       int[][]f=new int[n][n];
       //初始化
       f[0][0]=triangle.get(0).get(0);
        for (int i = 1; i <n; i++) {
            //每一行的第一个都只能由上一行的第一个加上当前数字获得
            f[i][0]=f[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;i++)
            {
                f[i][j]=Math.min(f[i-1][j-1],f[i][j-1])+triangle.get(i).get(j);
            }
            f[i][i]=f[i-1][i-1]+triangle.get(i).get(i);
        }
        //将所有的路径都加到了最后一行
        int mintotal=f[n-1][0];
        for (int i = 1; i <n; i++) {
            mintotal=Math.min(mintotal,f[n-1][i]);
        }
        return mintotal;
    }
}
