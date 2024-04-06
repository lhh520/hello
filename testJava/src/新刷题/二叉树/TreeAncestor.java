package 新刷题.二叉树;

import java.util.Arrays;

public class TreeAncestor {
    //需要存储每一代的节点
    int[][]pa;
    public TreeAncestor(int n, int[] parent) {
        int m=32 - Integer.numberOfLeadingZeros(n);
        pa=new int[n][m];//
        for(int i=0;i<n;i++){
            pa[i][0]=parent[i];//每一个节点的0代祖先都是自己
        }
        for(int i=0;i<m-1;i++){
            for(int x=0;x<n;x++){
                int p=pa[x][i];
                pa[x][i+1]=p<0?-1:pa[p][i];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) > 0) { // k 的二进制从低到高第 i 位是 1
                node = pa[node][i];
                if (node < 0) break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        int a=treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
        int b=treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
        int c=treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
