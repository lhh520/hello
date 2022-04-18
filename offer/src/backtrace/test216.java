package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test216 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
      if(n>45)
         return lists;
      backtrace(k,n,1);
      for(int i=0;i<lists.size();i++){
          System.out.println(lists.get(i).toString());
      }
      return lists;
    }
    public void backtrace(int k,int n,int cur){
        if(cur>10)
            return;
//        if(list.size()+(9-cur)+1<k){
//            return;
//        }
        if(list.size()==k&&sum(list)==n){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(cur);
        backtrace(k,n,cur+1);
        list.remove(list.size()-1);
        backtrace(k,n,cur+1);
    }
    public int sum(List<Integer>list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum=sum+list.get(i);
        }
        return sum;
    }
    @Test
    public void test(){
       combinationSum3(9,45);
    }
}
