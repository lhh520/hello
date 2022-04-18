package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class offer113 {
    //存储有向图
    List<List<Integer>>edges;
    //标记节点的状态 0，未搜索，1，搜索中，2，已完成
    int[] visited;
    //数组模拟栈，下标n-1为栈底，0为栈顶
    int[]result;
    //栈下标
    int index;
    boolean valid=true;
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        edges=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++)
        {
            edges.add(new ArrayList<Integer>());
        }
        visited=new int[numCourses];
        result=new int[numCourses];
        index=numCourses-1;
        for(int[] info:prerequisites)
        {
            edges.get(info[1]).add(info[0]);
        }
        for(int i=0;i<numCourses&&valid;i++)
        {   //没有搜索过
            if(visited[i]==0)
                dfs(i);

        }
        if(!valid)
            return new int[0];
        return result;

    }
    public void dfs(int u)
    {   //当前节点搜索中
        visited[u]=1;
        //搜索其相邻节点
        //只要发现有环，停止搜索
        for(int v:edges.get(u))
        {
            if(visited[v]==0)
            {
                dfs(v);
                if(!valid)
                    return;
            }
            else if(visited[v]==1)
            {
                valid=false;
                return;
            }

        }
        visited[u]=2;
        result[index--]=u;
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        System.out.println(map.get(1));
    }
}

