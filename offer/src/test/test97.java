package test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class test97 {
    /*
    * 343. 整数拆分
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。*/
    public int integerBreak(int n) {
    int[]dp=new int[n+1];
    for(int i=2;i<=n;i++)
    {
        int curMax=0;
        for(int j=1;j<i;j++)
        {
            curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-1]));
        }
        dp[i]=curMax;
    }
    return dp[n];
    }
    //279组成一个数的完全平方数的数量
    public int numSquares(int n) {
        System.out.println(1);
    int[]f=new int[n+1];
    for(int i=1;i<=n;i++)
    {
        int minn=Integer.MAX_VALUE;
        for(int j=1;j*j<=i;j++)
        {
            minn=Math.min(minn,f[i-j*j]);
        }
        f[i]=minn+1;
    }
    return f[n];
    }
    @Test
    public void test()
    {
        int n=12;
        System.out.println(numSquares(3));
    }
    //331
    public boolean isValidSerialization(String preorder) {
    if(preorder==null&&preorder.length()==0) return true;
    //转化为数组
    String[] str=preorder.split(",");
    int n=str.length;
    if(str[0].equals("#")&&n>1)return false;
    if(str[0].equals("#"))return true;
    Deque<String>stack=new LinkedList<>();
    int i=0;
    while (i<n)
    {
        String c=str[i];
        if(!c.equals("#"))
        {stack.push(c);
         i++;
        }
        else
        {
            if("#".equals(stack.peek()))
            {
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            else
            {
                stack.push(c);
                i++;
            }
        }
    }
    return stack.size()==1&&"#".equals(stack.peek());
    }
    //450. 删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root==null)
        return null;
    if(key<root.val)
        root.left=deleteNode(root.left,key);
    else if(key>root.val)
        root.right=deleteNode(root.right,key);
    else
    {
        //找到了等于目标值的节点
        //1.case1:当前的值左右子树都不为空
        if(root.left!=null&&root.right!=null)
        {   //查找右子树的的
            TreeNode prev=root;
            TreeNode next=root.right;

            while (next.left!=null)
            {
                prev=next;
                next=next.left;
            }
            //先删除最左子树节点，prev是当前的最左节点
            if(prev==root)
                prev.right=next.right;
            else
                prev.left=next.right;
            //删除节点，改为
            root.val=next.val;

        }
        else if(root.left==null)
            return root.right;
        else
            return root.left;

    }

    return root;
    }
    public TreeNode deleteNode1(TreeNode root, int key)
    {   if(root==null)
        return null;
        if(root.val<key)
            root.right=deleteNode1(root.right,key);
        else if(root.val>key)
            root.left=deleteNode(root.left,key);
        else
        //已经找到了当前的节点
        {
            if(root.left==null)
                root=root.right;
            else if(root.right==null)
                root=root.left;
            else
            {
                TreeNode pr=root.right;
                while (pr.left!=null)
                {
                    pr=pr.left;
                }
                pr.left=root.left;
                root=root.right;
            }
        }
        return root;
    }
}
