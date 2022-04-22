package back;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test216 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>45)
            return lists;
        //System.out.println(1);
        backtrace(n,1,k);
        return lists;
    }

    public void backtrace(int n,int index,int k){
        if(list.size()==k&&sum(list)==n){//终止条件
            System.out.println(list.toString());
            lists.add(new ArrayList<>(list));
            return;
        }
        //处理本层元素
        for(int i=index;i<=9;i++){
            list.add(i);
            //选两个元素
            backtrace(n,i+1,k);
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
        int k = 3, n = 7;
        combinationSum3(3,7);
    }
}
