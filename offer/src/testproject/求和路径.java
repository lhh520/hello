package testproject;

import org.junit.Test;

import java.util.*;

public class 求和路径 {
    List<List<Integer>>lists=new ArrayList<>();
    List<Integer>list=new ArrayList<>();
    public int pathSum(TreeNode root, int sum) {
        backtrace(root);
        int ret=0;
        //已经获取到了所有的lists
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }
        for(int i=0;i<lists.size();i++){
            List<Integer>cur=lists.get(i);//获取到了当前的值
            int curans=0;
            HashMap<Integer,Integer>map=new HashMap<>();//构造前缀和
            int cursum=0;
            for(int j=0;j<cur.size();j++){
                cursum+=cur.get(j);
                if(map.containsKey(cursum-sum)){//如果包含
                    curans++;
                }
                map.put(cursum,j);
            }
            ret+=curans;
        }
        return ret;
    }
    public void backtrace(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }

        backtrace(root.left);
        backtrace(root.right);
        list.remove(list.size()-1);
    }
    public int pathSum1(TreeNode root, int sum){
        Map<Long,Integer>prefix=new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,prefix,0,sum);
    }
    public int dfs(TreeNode root,Map<Long,Integer>prefix,long curr,int sum){
        if(root==null){
            return 0;
        }
        int ret=0;
        curr+=root.val;
        ret+=prefix.getOrDefault(curr-sum,0);//看当前的路径中是否存在数字
        prefix.put(curr,prefix.getOrDefault(curr-sum,0)+1);
        ret+=dfs(root.left,prefix,curr,sum);
        ret+=dfs(root.right,prefix,curr,sum);
        prefix.put(curr,prefix.getOrDefault(curr-sum,0)-1);
        return ret;
    }
    @Test
    public void test(){
        List<Integer>uu=new ArrayList<>();
        uu.add(5);
        uu.add(4);
        uu.add(11);
        uu.add(2);
        int curans=0;
        HashMap<Integer,Integer>map=new HashMap<>();//构造前缀和
        int cursum=0;
        map.put(0,0);
        for(int j=0;j<uu.size();j++){
            cursum+=uu.get(j);
            System.out.println(cursum);
            if(map.containsKey(cursum-22)){//如果包含
                curans++;
            }
            map.put(cursum,j);
        }
        System.out.println(curans);
    }
}
