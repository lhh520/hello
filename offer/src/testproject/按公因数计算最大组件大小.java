package testproject;

import java.util.Arrays;

public class 按公因数计算最大组件大小 {
    public int largestComponentSize(int[] nums) {
        int m= Arrays.stream(nums).max().getAsInt();
        UnionFind uf=new UnionFind(m+1);
        for(int num:nums){
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    uf.union(num,i);
                    uf.union(num,num/i);
                }
            }
        }
        int[]count=new int[m+1];
        int ans=0;
        for(int num:nums){
            int root=uf.find(num);
            count[root]++;
            ans=Math.max(ans,count[root]);
        }
        return ans;
    }
}
class UnionFind{
    int[]parent;
    int[]rank;
    public UnionFind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        rank=new int[n];
    }
    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        //如果不是一伙的 则需要合并
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }
    public int find(int x){//找到最后的数字
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
}
