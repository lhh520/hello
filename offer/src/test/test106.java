package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test106 {
   List<List<Integer>>edges;
   int[] indeg;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++)
    {   //用来存储到当前点所有的前驱节点
        edges.add(new ArrayList<Integer>());
    }
    indeg=new int[numCourses];//入度计算
    for(int[] te:prerequisites)
    {
        edges.get(te[1]).add(te[0]);
        ++indeg[te[0]];
    }
    int visited=0;
    Queue<Integer>queue=new LinkedList<>();
    for(int i=0;i<numCourses;i++)
    {
        if(indeg[i]==0)
            queue.add(i);//将入度为0的点加入队列
    }
    while (!queue.isEmpty())
    {
        ++visited;//将要弹出一个点，表明已经进行了访问
        int u=queue.poll();
        for(int v:edges.get(u))//开始遍历所有得到的后继节点
        {
            --indeg[v];
            if(indeg[v]==0)
                queue.add(v);
        }
    }
    return visited==numCourses;
    }
}
