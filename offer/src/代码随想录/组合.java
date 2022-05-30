package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,1,k);
        return lists;
    }
    public void dfs(int n,int index,int k){
//        if(index==n+1){//表示已经到了末尾了
//            return;
//        }
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        //开始循环搜索
        for(int i=index;i<=n;i++){//所有的可以选择的条件
            list.add(i);
            dfs(n,i+1,k);//表示从下一个数值开始 不会重复
            list.remove(list.size()-1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>>temp=combine(4,2);
        for(List<Integer>yy:temp){
            System.out.println(yy.toString());
        }
    }
}
