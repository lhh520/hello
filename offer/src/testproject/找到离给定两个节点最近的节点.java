package testproject;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 找到离给定两个节点最近的节点 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int len=edges.length;
        //先求node到任意点的距离
        Map<Integer,Integer>map=new HashMap<>();
        map.put(node1,0);
        int cur1=node1;
        int cur2=node2;
        Map<Integer,Integer>map1=new HashMap<>();
        map1.put(node2,0);
        while (node1!=-1){
            if(edges[node1]==cur1||map.containsKey(edges[node1])){
                break;
            }
            if(edges[node1]!=-1&&edges[node1]!=cur1&&!map.containsKey(edges[node1]))
            map.put(edges[node1],map.getOrDefault(node1,0)+1);
            node1=edges[node1];
        }
        while (node2!=-1){
            if(edges[node2]==cur2||map1.containsKey(edges[node2])){
                break;
            }
            if(edges[node2]!=-1&&edges[node2]!=cur2&&!map1.containsKey(edges[node2]))
                map1.put(edges[node2],map1.getOrDefault(node2,0)+1);
            node2=edges[node2];
        }
        int ret=Integer.MAX_VALUE;
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            //当前的值
            int cur=Math.max(entry.getValue(),map1.getOrDefault(entry.getKey(),Integer.MAX_VALUE));
            if(cur<ret){
                ret=cur;
                ans=entry.getKey();
            }
            ret=Math.min(cur,ret);
        }
        return ret==Integer.MAX_VALUE?-1:ans;
    }
    //
    public int closestMeetingNode1(int[] edges, int node1, int node2){
        int[]r1=reach(node1,edges);
        int[]r2=reach(node2,edges);
        int min=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<edges.length;i++){
            if(r1[i]==-1||r2[i]==-1) continue;
            int t=Math.max(r1[i],r2[i]);
            if(t<min){
                min=t;
                ans=i;
            }
        }
        return ans;
    }
    public int[]reach(int node,int[]edges){
        int[]r=new int[edges.length];
        int cur=node;
        int next=edges[node];
        int len=0;
        //如果节点已经遍历过 退出 防止死循环
        while (next!=-1&&r[next]==0){
            len++;
            node=next;
            next=edges[next];
            r[node]=len;
        }
        for(int i=0;i<edges.length;i++){
            if(i==cur) r[i]=0;//如果自身有环 则应该设计为0
            else if(r[i]==0) r[i]=-1;//说明不可达  直接赋值为-1
  }
        return r;
    }


    @Test
    public void test(){
        int[]edges=new int[]{4,4,4,5,1,2,2};
        System.out.println(closestMeetingNode(edges,1,1));
    }
}
