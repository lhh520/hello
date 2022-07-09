package 热题100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 统计无向图中无法互相到达点对数 {
    public long countPairs(int n, int[][] edges) {
        UnionFind u=new UnionFind(n);
        for(int[]edg:edges){
           u.union(edg[0],edg[1]);
        }
        int[]sz=u.size();
        List<Integer> list=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            int p= u.find(i);
            if(set.contains(p)) list.add(sz[p]);
            set.add(p);
        }
        long ans=0;
        for(int szs:list){
            ans+=(long)szs*(n-szs);
        }
        return ans/2;
    }

    private class UnionFind{
        private int[]parent;
        private int count;
        private int[] size;
        public int getCount(){
            return count;
        }
        public UnionFind(int n){
            this.count=n;
            this.parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i] = 1;
            }
        }
        public int[] size() {
            return this.size;
        }
        public int find(int x){
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }
        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY){
                return;
            }
            if(size[rootX]<size[rootY]){
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }else {
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }

            count--;
        }
    }
}
