package testproject;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

public class 有重复字符串的排列组合 {
    char[]cc;
    List<String>list=new ArrayList<>();
    Set<String>set=new HashSet<>();
    public String[] permutation(String S) {//
        cc=S.toCharArray();
        backtrace(S,0);
        String[]strs=new String[list.size()];
        for(int i=0;i<list.size();i++){
            strs[i]=list.get(i);
        }
        return strs;
    }
    public void backtrace(String S,int index){
        if(set.add(new String(cc)))
        list.add(new String(cc));
        for(int i=index;i<S.length();i++){
            char temp=cc[i];
            cc[i]=cc[index];
            cc[index]=temp;
            backtrace(S,i+1);
            char temp1=cc[i];
            cc[i]=cc[index];
            cc[index]=temp1;
        }
    }
    @Test
    public void test(){
        String S = "qqe";
        String[]nn=permutation(S);
        System.out.println(Arrays.toString(nn));
    }
}
