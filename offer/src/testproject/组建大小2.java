package testproject;

import java.util.Arrays;

public class 组建大小2 {
    int[]cnt;
    int N=100010;
    public int largestComponentSize(int[] nums){

        cnt=new int[100010];
        Unionfind uf=new Unionfind(N);
        for(int num:nums){
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    uf.union(num,i);
                    if(i!=num/i){
                        uf.union(num,num/i);
                    }
                }
            }
        }
        int ans=1;
        for(int num:nums){
            cnt[uf.find(num)]++;
            ans=Math.max(ans,cnt[uf.find(num)]);
        }
        return ans;
    }
    class Unionfind{
        int[]parent;
        public Unionfind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }
        public int find(int index){
            if(index==parent[index]){
                return index;
            }else {
                return find(parent[index]);
            }
        }
    }
}
