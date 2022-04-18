package LCP;

import java.util.ArrayList;
import java.util.List;

public class LCP07 {
    int ways,n,k;
    List<List<Integer>>edges;
    public int numWays(int n, int[][] relation, int k) {
    ways=0;
    this.n=n;
    this.k=k;
    edges=new ArrayList<List<Integer>>();
        for (int i = 0; i <n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        //将所有的点与当前的点有连接的全部进行保存
        for(int[]edge:relation)
        {
            int src=edge[0],dst=edge[1];
            edges.get(src).add(dst);
        }
        //开始递归搜索，index表示已经索引到的点
        //steps表示前进的步数
        dfs(0,0);
        return ways;
    }
    public void dfs(int index,int steps)
    {   //判定当已经走完步数，满足传递条件，则继续传递
        if(steps==k)
        {
            if(index==n-1)
                ways++;
            return;
        }
        //表示当前的可以前往的下一个站点，进行遍历搜索
        List<Integer>list=edges.get(index);
        for(int ne:list)
            dfs(ne,steps+1);
    }
    public boolean canBeIncreasing(int[] nums) {
        int flag=0;
        for (int i = 0; i <nums.length-1; i++) {
            if(nums[i+1]<nums[i])
            {
                flag++;
            }
        }
        if(flag<2)
            return true;
        return false;
    }
}
