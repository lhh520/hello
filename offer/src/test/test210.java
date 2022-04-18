package test;

import java.util.ArrayList;
import java.util.List;

public class test210 {
    List<List<Integer>>edges;
    int[] visited;
    int[] result;
    int index;
    boolean valid=true;
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
       edges=new ArrayList<List<Integer>>();
       for(int i=0;i<numCourses;i++)
       {
           edges.add(new ArrayList<Integer>());
       }
       index=numCourses-1;
       visited=new int[numCourses];
       result=new int[numCourses];
       //构造有效边，将所有的课程的先修课程放入链表中
       for(int[]info:prerequisites)
           edges.get(info[1]).add(info[0]);
       //对所有的数据进行遍历
       for(int i=0;i<numCourses&&valid;i++)
       {
           if(visited[i]==0)//进行搜索过的，则不再考虑
               dfs(i);
       }
       if(!valid)
           return new int[0];
       return result;
    }
    public void dfs(int u)
    {   //当前的节点已经进行了搜索
        visited[u]=1;
        //
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
}
