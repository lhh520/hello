package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test77 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        System.out.println(1);
        backtrace(n,1,k);
        return lists;
    }
    public void backtrace(int n,int index,int k){
         if(list.size()==k){//终止条件
             lists.add(new ArrayList<>(list));
             return;
         }
         //处理本层元素
         for(int i=index;i<=n;i++){
             list.add(i);
             //选两个元素
             backtrace(n,i+1,k);
             list.remove(list.size()-1);
         }
    }
    @Test
    public void test(){
        combine(4,2);
        for(List<Integer>list1:lists){
            System.out.println(list1.toString());
        }
    }
}
