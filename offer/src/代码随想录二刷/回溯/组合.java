package 代码随想录二刷.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        backtrace(1,k);
        return lists;
    }
    public void backtrace(int index,int k){
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(index>n){
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            backtrace(i+1,k);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>>ans=combine(4,2);
        for(List<Integer>ll:ans){
            System.out.println(ll.toString());
        }
    }
}
