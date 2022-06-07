package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 分割回文子字符串 {
    List<String>list=new ArrayList<>();
    List<List<String>>lists=new ArrayList<>();
    String ss;
    public String[][] partition(String s) {
        char[]cc=s.toCharArray();
        ss=s;
        backtrace(cc,0);
        int sz=lists.size();
        String[][]ans=new String[sz][];
        for(int i=0;i<sz;i++){
            List<String>kk=lists.get(i);
            String[]temp=new String[kk.size()];
            for(int j=0;j<kk.size();j++){
                temp[j]=lists.get(i).get(j);
            }
            ans[i]=temp;
        }
        return ans;
    }
    public void backtrace(char[]cc,int index){
        if(index==cc.length){//表示分割清楚，得到答案直接返回
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<cc.length;i++){
            if(check(cc,index,i)){
                list.add(ss.substring(index,i+1));
            }else {
                continue;
            }
            backtrace(cc,i+1);
            list.remove(list.size()-1);
        }
    }
    public boolean check(char[]cc,int i,int j){
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
        String s="google";
        partition(s);
    }
}
