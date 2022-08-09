package 代码随想录二刷.回溯;
import java.util.*;
public class 分割回文串 {
    List<List<String>>lists=new ArrayList<>();
    List<String>list=new ArrayList<>();
    public List<List<String>> partition(String s){
        char[]chars=s.toCharArray();
        backtrace(s,0);
        return lists;
    }
    public void backtrace(String s,int index){
        if(index>=s.length()){//如果起始位置大于S大小 说明找到了一组分割的方案
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){//如果满足条件
                String ss=s.substring(index,i+1);
                list.add(ss);
            }else {
                continue;
            }
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
}
