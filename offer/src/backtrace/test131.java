package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test131 {
    List<String>list=new ArrayList<>();
    List<List<String>>lists=new ArrayList<>();
    public List<List<String>> partition(String s) {
    backtrace(s,0);
    return lists;
    }
    public void backtrace(String s,int index){
    if(index>=s.length()){
        lists.add(new ArrayList<>(list));
        return;
    }
    for(int i=index;i<s.length();i++){
        if(isPalindrome(s,index,i)){
            String ss=s.substring(index,i+1);
            list.add(ss);
        }
        else
            continue;
        backtrace(s,i+1);
        list.remove(list.size()-1);
    }
    }
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String s="aab";

    }
}
