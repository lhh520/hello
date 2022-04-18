package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class test357 {

    /**
     * 题解1：10个数字不同的进行组合，看能组合多少个
     * 题解2：将重复的数字进行计数，10^n-重复的数字
     * */
    HashSet<String>set=new HashSet<>();
    int[] visited;
    public int countNumbersWithUniqueDigits(int n) {
    //0 1 2 3 4 5 6 7 8 9
    if(n==0) return 1;
    int[]nums=new int[]{0,1,2,3,4,5,6,7,8,9};
    visited=new int[10];
    int sum=0;
    //计算每一位都有几个不同的数
    for(int i=1;i<=n;i++)
    {
        StringBuilder sb=new StringBuilder();
        dfs(i,sb,nums);
        sum+=set.size();
        set=new HashSet<>();
    }
    return sum+1;//加上单独的那个0
    }
    public void dfs(int n,StringBuilder sb,int[]nums)
    {   //已经拼凑够当前的数字
        if(sb.length()==n&&!set.contains(sb.toString()))
            set.add(sb.toString());
        for(int i=0;i<nums.length;i++)
        {   //单独的0不能出现在首位
            if(sb.length()==0&&nums[i]==0) continue;
            //剪枝,当前的长度等于n，则直接跳出循环
            if(sb.length()==n)
                break;
            //如果数字已经添加过，则不能重复添加
            if(visited[nums[i]]==1) continue;
            //进行回溯,将当前的数字设置为1，表示已经用过了
            visited[nums[i]]=1;
            //将当前的数字添加
            sb.append(nums[i]);
            //添加之后进行遍历
            dfs(n,sb,nums);
            //遍历之后，恢复原状
            visited[nums[i]]=0;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void test()
    {
        System.out.println(countNumbersWithUniqueDigits(2));
    }
}
