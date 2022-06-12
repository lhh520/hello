package testproject;

import org.junit.Test;

import java.util.*;

public class 网络延迟时间 {
    public int networkDelayTime(int[][] times, int n, int k) {
        //先求出度
        Queue<Integer>queue=new LinkedList<>();
        int[]inDeg=new int[n+1];
        for(int i=0;i<times.length;i++){
            inDeg[times[i][1]]++;
        }
        boolean[]flag=new boolean[n+1];
        System.out.println(Arrays.toString(inDeg));
        queue.add(k);
        flag[k]=true;
//        for(int i=1;i<inDeg.length;i++){
//            if(inDeg[i]==0){
//                queue.add(i);
//                flag[i]=true;
//            }
//        }
        int second=0;
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                int node=queue.poll();
                int cur=0;
                for(int j=0;j<times.length;j++){
                    if(times[j][0]==node){
                        cur=Math.max(cur,times[j][2]);
                        flag[times[j][1]]=true;
                        inDeg[times[j][1]]--;
                        if(inDeg[times[j][1]]==0){
                            queue.add(times[j][1]);
                        }
                    }
                }
                second+=cur;
            }

        }
        for(int i=1;i<flag.length;i++){
            if(!flag[i]){
                return -1;
            }
        }
        return second;
    }
    //
    int INTMAX = 0x3f3f3f3f;
    public int networkDelayTime1(int[][] times, int n, int k){
        Map<Integer, Map<Integer,Integer>>map=new HashMap<>();
        for(int[]edg:times){
            if(!map.containsKey(edg[0])){
                map.put(edg[0],new HashMap<>());
            }
            map.get(edg[0]).put(edg[1],edg[2]);
        }
        int[]r=new int[n+1];
        for(int i=0;i<=n;i++){
            r[i]=INTMAX;
        }
        r[k]=0;
        Deque<int[]>s=new ArrayDeque<>();
        s.addLast(new int[]{k,0});
        while (!s.isEmpty()){
            int[]cur=s.peekFirst();
            if(map.containsKey(cur[0])){
                for(int v:map.get(cur[0]).keySet()){
                    int t=map.get(cur[0]).get(v)+cur[1];
                    if(t<r[v]){
                        r[v]=t;
                        s.addLast(new int[]{v,t});
                    }
                }
            }
        }
        int miniT=-1;
        for(int i=1;i<=n;i++){
            miniT=Math.max(miniT,r[i]);
        }
        return miniT==INTMAX?-1:miniT;
    }
    @Test
    public void test(){
        int[][]times =new int[][]{{1,2,1}};
        System.out.println(networkDelayTime(times,2,2));
    }
}
