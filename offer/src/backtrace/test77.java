package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test77 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
    backtrace1(1,n,k);
    return lists;
    }
    public void backtrace(int cur,int n,int k){
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=cur;i<=n-(k-list.size())+1;i++){
            list.add(i);
            backtrace(i+1,n,k);
            list.remove(list.size()-1);
        }
    }
    public void backtrace1(int cur,int n,int k){
        if(list.size()+(n-cur+1)<k){//已经没有足够的数了
            return;
        }
        if(list.size()==k){

            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(cur);
        backtrace1(cur+1,n,k);
        list.remove(list.size()-1);
        backtrace1(cur+1,n,k);
    }
    @Test
    public void test(){
        combine(4, 2);
    }
}
