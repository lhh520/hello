package testproject;

import java.util.ArrayList;
import java.util.List;

public class 冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        //并查集
        int n=edges.length;
        int[]parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            int node1=edges[i][0];
            int node2=edges[i][1];
            if(find(parent,node1)!=find(parent,node2)){
                union(parent,node1,node2);
            }else {
                //相等则说明出现了重复的节点
                    return edges[i];
            }
        }
        return new int[]{0};
    }
    public void union(int[] parent, int index1, int index2) {
        int index1_fa=find(parent, index1);
        int index2_fa=find(parent, index2);
        parent[index1_fa] =index2_fa;
    }

    public int find(int[] parent, int index) {
        if(parent[index]==index){
            return index;
        }else {
            return find(parent,parent[index]);
        }
    }
    //
    public int[] findRedundantConnection1(int[][] edges){
        int n=edges.length;
        int[]parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        //
        for(int i=0;i<edges.length;i++){
            int[]edg=edges[i];
            //从一下点开始出发
            int node1=edg[0];
            int node2=edg[1];
            if(find(parent,node1)!=find(parent,node2)){//找不到自己的父亲
                union(parent,node1,node2);
            }else {
                return edg;
            }

        }
        return new int[]{};
    }
    //查找函数
    public int find1(int[]parent,int index){
        if(parent[index]==index){
            return index;
        }else {
            return find(parent,parent[index]);//每一点存储的都是自己的父亲
        }
    }
    //合并函数
    public void unit(int[]parent,int index1,int index2){
        int index_1=find1(parent,index1);
        int index_2=find(parent,index2);
        parent[index_1]=index_2;
    }

}
