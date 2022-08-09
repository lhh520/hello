package 代码随想录二刷.回溯;
import java.util.*;
public class 复原IP地址 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    int count=3;
    public List<String> restoreIpAddresses(String s){
        backtrace(s,0);
        return list;
    }
    public void backtrace(String s,int index){
        if(count<=0){
            if(isValid(s,index,s.length()-1)){//最后一个有效 则可以
                list.add(s);
            }
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isValid(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                count--;
                backtrace(s,i+2);
                s=s.substring(0,i+1)+s.substring(i+2);
            }else {//一旦开始出现不合法 后面的都不合法
                continue;
            }
        }
    }
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
