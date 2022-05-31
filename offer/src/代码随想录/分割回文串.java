package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    List<List<String>>lists=new ArrayList<>();
    List<String>list=new ArrayList<>();
    //s = "aab"
    public List<List<String>> partition(String s){
        char[]cc=s.toCharArray();
        backtrace(cc,0,s);
        return lists;
    }
    public void backtrace(char[]cc,int index,String s){
        if(index==s.length()){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++){//所有的选择
            if(isPalime(cc,index,i)){
                list.add(s.substring(index,i+1));
            }else {
                continue;
            }
            backtrace(cc,i+1,s);
            list.remove(list.size()-1);
        }
    }
    boolean isPalime(char[]cc,int i,int j){
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
        String s= "aab";
        List<List<String>>lists1=partition(s);
        for(List<String>ll:lists1){
            System.out.println(ll.toString());
        }
    }
}
