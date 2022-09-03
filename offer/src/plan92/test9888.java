package plan92;



import backtrace.TreeNode;

import java.util.*;

public class test9888 {
    static Set<Character>set=new HashSet<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String str1=sc.nextLine();
        String[]strings=str1.split(" ");
        int[]nums=new int[strings.length];

        for(int i=0;i<strings.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
        }
//        6
//        1 2 2 1 4
//        ABCCAD
        String str2=sc.nextLine();
        System.out.println(1);
        Queue<TreeNode>queue=new LinkedList<>();
        Queue<Integer>queue1=new LinkedList<>();
        TreeNode root=new TreeNode(str2.charAt(0));
        queue.add(root);
        queue1.add(1);
        System.out.println(2);
        while (!queue.isEmpty()){
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                TreeNode node=queue.poll();
                int val=queue1.poll();
                for(int j=0;j< nums.length;j++){
                    if(nums[j]==val){
                        TreeNode tmp=new TreeNode(str2.charAt(j+1));
                        if(node.left!=null){
                            node.left=tmp;
                        }else {
                            node.right=tmp;
                        }
                        queue.add(tmp);
                        queue1.add(nums[j]);
                    }
                }
            }
        }


    }
    public static void dfs(TreeNode root){
         if(root==null){
             return;
         }
         dfs(root.left);
         set.add(root.val);
         dfs(root.left);

    }
      static class TreeNode {
        Character val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(Character val) {
            this.val = val;
        }
    }

}
