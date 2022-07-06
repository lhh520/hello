package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 从叶结点开始的最小字符串 {
    List<String>list;
    public String smallestFromLeaf(TreeNode root) {
        list=new ArrayList<>();
        dfs(root,"");
        Collections.sort(list);
        return list.get(0);
    }
    public void dfs(TreeNode root,String s){
        if(root==null){
            return;
        }
        s+=(char)('a'+root.val);
        if(root.left==null&&root.right==null){
            StringBuilder sb=new StringBuilder(s);
            list.add(sb.reverse().toString());
            return;
        }
        dfs(root.left,s);
        dfs(root.right,s);
    }
}
