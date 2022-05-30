package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n>46){
            return lists;
        }
        dfs(k,n,1);
        return lists;
    }
    public void dfs(int k,int sum,int index){
        //回溯到最底层，返回值
        if(sum==0&&list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index>=10||sum<0||list.size()>k){
            return;
        }

        for(int i=index;i<=9;i++){
            list.add(i);
            sum=sum-i;
            dfs(k,sum,i+1);
            list.remove(list.size()-1);
            sum=sum+i;
        }
    }
    @Test
    public void test(){
        List<List<Integer>>temp=combinationSum3(9,45);
        for(List<Integer>li:temp){
            System.out.println(li.toString());
        }
    }
}
