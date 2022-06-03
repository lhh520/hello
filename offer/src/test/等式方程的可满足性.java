package test;

public class 等式方程的可满足性 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        //并查集初始化集合全是自己
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //合并过程
        for(String str:equations){
            if(str.charAt(1)=='='){
                int index1=str.charAt(0)-'a';
                int index2=str.charAt(3)-'a';
                union(parent,index1,index2);
            }
        }
        for(String str:equations){
            if(str.charAt(1)=='!'){
                int index1=str.charAt(0)-'a';
                int index2=str.charAt(3)-'a';
                if(find(parent,index1)==find(parent,index2)){
                    return false;
                }
            }
        }
        return true;
    }
    //
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);//
    }
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
