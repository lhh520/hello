package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        dfs(1,n,k);
        return lists;
    }
    public void dfs(int index,int n,int k){
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            dfs(i+1,n,k);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>>listq=combine(4,2);
        System.out.println(listq);
    }
}
