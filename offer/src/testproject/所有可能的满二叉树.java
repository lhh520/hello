package testproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 所有可能的满二叉树 {
    Map<Integer,List<TreeNode>>memo=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!memo.containsKey(n)){
            List<TreeNode>ans=new ArrayList<>();
            if(n==1){
                ans.add(new TreeNode(0));
            }else if(n%2==1){
                for(int x=0;x<n;x++){
                    int y=n-1-x;
                    for(TreeNode left:allPossibleFBT(x)){
                        for(TreeNode right:allPossibleFBT(y)){
                            TreeNode bns=new TreeNode(0);
                            bns.left=left;
                            bns.right=right;
                            ans.add(bns);
                        }

                    }
                }
            }
            memo.put(n,ans);
        }
        return memo.get(n);
    }
}
