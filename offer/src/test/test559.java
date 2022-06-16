//package test;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};
//public class test559 {
//    public int maxDepth(Node root) {
//    if(root==null)
//        return 0;
//    if(root.children.isEmpty())
//        return 1;
//    int ans=dfs(root);
//    return ans;
//    }
//    public int dfs(Node root)
//    {
//        if(root==null)
//            return 0;
//        if(root.children.isEmpty())
//            return 1;
//        List<Integer>ans=new ArrayList<>();
//        for(int i=0;i<root.children.size();i++)
//        {
//             ans.add(dfs(root.children.get(i)));
//        }
//        return Collections.max(ans)+1;
//    }
//}
//
