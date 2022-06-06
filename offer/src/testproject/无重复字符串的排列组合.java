package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 无重复字符串的排列组合 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public String[] permutation(String S) {
        char[]cc=S.toCharArray();
        //全排列
        backtrace(cc,0);
        System.out.println(list.toString());
        String[]ans=new String[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    public void backtrace(char[]cc,int index){
        if(index==cc.length){
            String ss=new String(cc);
            list.add(ss);
            return;
        }
        for(int i=index;i<cc.length;i++){
            swap(cc,index,i);
            backtrace(cc,index+1);
            swap(cc,index,i);
        }
    }
    public void swap(char[]cc,int i,int j){
        char temp=cc[i];
        cc[i]=cc[j];
        cc[j]=temp;
    }
    @Test
    public void test(){
        String S = "qwe";
        String[]ans=permutation(S);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
