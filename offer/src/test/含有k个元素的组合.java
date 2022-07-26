package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 含有k个元素的组合 {
    List<Integer>list;
    List<List<Integer>>ret;
    public List<List<Integer>> combine(int n, int k) {
        list=new ArrayList<>();
        ret=new ArrayList<>();
        backtrace(1,n,k);
        return ret;
    }
    public void backtrace(int index,int n, int k){
        if(list.size()==k){
            ret.add(new ArrayList<>(list));
            return;
        }
        if(index>n){
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            backtrace(i+1,n,k);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>>ans=combine(4,2);
        System.out.println(ans);
    }
}
