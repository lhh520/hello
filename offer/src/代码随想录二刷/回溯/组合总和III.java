package 代码随想录二刷.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合总和III {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(1,n,k);
        return lists;
    }
    public void backtrace(int index,int sum,int k){
        if(list.size()==k&&sum==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<=9;i++){
            list.add(i);
            backtrace(i+1,sum-i,k);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>>ans=combinationSum3(3,7);
        for(List<Integer>ll:ans){
            System.out.println(ll.toString());
        }
    }
}
