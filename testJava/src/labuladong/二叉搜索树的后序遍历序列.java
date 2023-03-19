package labuladong;

public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[]poster,int i,int j){//[i，j]表示当前处理的是i到j的子区间内
        if(i>=j) return true;//说明还没到最终的结果
        int p=i;
        while (poster[p]<poster[j]) p++;//找到第一个大于根节点的数字，从i到m-1为左子树
        int m=p;
        while (poster[p]>poster[j])p++;//右子树必须大于根节点
        return p==j&&recur(poster,i,m-1)&&recur(poster,m,j-1);
    }
}
