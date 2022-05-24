package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 排列序列 {
    List<Integer> list=new ArrayList<>();
    List<String> temp=new ArrayList<>();
    public String getPermutation(int n, int k) {
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        backtrace(list,0,n);
        //System.out.println(temp.toString());
        Collections.sort(temp);
        //System.out.println(temp.toString());


        return temp.get(k-1);
    }
    public void backtrace(List<Integer>list,int index,int n){
        if(index==list.size()){
            //lists.add(new ArrayList<>(list));
            StringBuilder sb=new StringBuilder();
            for(int ii:list){
                sb.append(ii);
            }
            temp.add(sb.toString());
            return;
        }
        for(int i=index;i<list.size();i++){
            Collections.swap(list,index,i);
            backtrace(list,index+1,n);
            Collections.swap(list,index,i);
        }
    }



    @Test
    public void test(){
        int n = 3, k = 3;
        System.out.println(getPermutation(3,5));
    }
}
