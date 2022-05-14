package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 分割回文串 {
    List<List<String>>lists=new ArrayList<>();
    List<String>list=new ArrayList<>();
    //[["a","a","b"],["aa","b"]]
    public List<List<String>> partition(String s) {
        char[]cc=s.toCharArray();
        backtrace(cc,0,s);
        return lists;
    }
    public void backtrace(char[]cc,int index,String s){
        if(index==cc.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<cc.length;i++){
            if(isPalime(cc,index,i)){
                list.add(s.substring(index,i+1));
            }else {
                continue;
            }
            backtrace(cc,i+1,s);

            list.remove(list.size()-1);
        }
    }
    //判定是不是回文串
    public boolean isPalime(char[]cc,int i,int j){
        while (i<j){
            if(cc[i]!=cc[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    @Test
    public void test(){
        String ss="aab";
        List<List<String>>ans=partition(ss);
        for(List<String>ll:ans){
            System.out.println(ll.toString());
        }
    }
}
