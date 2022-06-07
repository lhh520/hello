package testproject;

import org.junit.Test;

import java.util.*;

public class 出现次数最多的子树元素和 {
    List<Integer>list=new ArrayList<>();
    int max=0;
    Map<Integer,Integer>map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        //list.add(dfs(root));
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()==max){
                list.add(entry.getKey());
            }
        }
        int[]nums=new int[list.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }
        return nums;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int node=left+right+root.val;
        //list.add(node);
        map.put(node,map.getOrDefault(node,0)+1);
        if(map.get(node)>max){
            max=map.get(node);
        }
        return node;
    }
    @Test
    public void test(){
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(-3);
        a.left = b;
        a.right = c;
        int[]nums=findFrequentTreeSum(a);
        System.out.println(Arrays.toString(nums));
    }

}
