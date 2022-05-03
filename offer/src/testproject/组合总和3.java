package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合总和3 {
    List<Integer> list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n){

        if(n>45){
            return lists;
        }
        dfs(k,n,1);
        return lists;
    }
    public void dfs(int k,int n,int index){
       if(list.size()==k&&sum(list)==n){
           lists.add(new ArrayList<>(list));
           return;
       }
       for(int i=index;i<=9;i++){
           list.add(i);
           dfs(k,n,i+1);
           list.remove(list.size()-1);

       }
    }
    public int sum(List<Integer>list2){
        int sunlist=0;
        for(int i:list2){
            sunlist+=i;
        }
        return sunlist;
    }
    @Test
    public void test(){
        List<List<Integer>>ans=combinationSum3(3,7);
        System.out.println(ans.toString());
    }
}
