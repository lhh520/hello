package 热题100;

import java.util.*;

public class 引爆最多的炸弹 {
    public boolean isConnect(int[][] bombs,int u, int v){//u能否点燃
        long ru = (long)bombs[u][2] * bombs[u][2];
        long dx = bombs[u][0] - bombs[v][0];
        long dy = bombs[u][1] - bombs[v][1];
        return ru >= (long)dx * dx + dy * dy;
    }
    public int maximumDetonation(int[][] bombs) {
        //挨个尝试
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for(int i=0;i<bombs.length;i++){
            List<Integer>list=new ArrayList<>();
            for(int j=0;j<bombs.length;j++){
                if(i!=j&&isConnect(bombs,i,j)){
                    list.add(j);
                }
            }
            edges.put(i,new ArrayList<>(list));
        }
        Queue<Integer>queue=new LinkedList<>();
        int res=0;
        for(int i=0;i<bombs.length;i++){
            boolean[]visit=new boolean[bombs.length];
            queue.offer(i);
            int union=1;
            while (!queue.isEmpty()){
                int u=queue.poll();
                List<Integer>temp=edges.get(u);
                for(int v:temp){
                    if(!visit[v]){
                        visit[v] = true;
                        queue.offer(v);
                        union++;
                    }
                }
            }
            res=Math.max(res,union);
        }
        return res;
    }
}
