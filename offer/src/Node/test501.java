package Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test501 {
    List<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        System.out.println(list.toString());
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
            max=Math.max(max,map.get(list.get(i)));
        }
        List<Integer>ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getKey()==max){
                ans.add(entry.getValue());
            }
        }
        int[]nums=new int[ans.size()];
        for(int i=0;i<nums.length;i++){
            nums[i]=ans.get(i);
        }
        return nums;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
