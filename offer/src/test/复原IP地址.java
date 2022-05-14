package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    List<String>list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    //s = "25525511135"
    int count=3;
    public List<String> restoreIpAddresses(String s) {

        backtrace(s,0);
        return list;
    }
    public void backtrace(String s,int index){
        if(count<=0){
            //list.add(new String(sb));
            if(isValid(s,index,s.length()-1)){
                list.add(s);
            }
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isValid(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                count--;
                backtrace(s,i+2);
                count++;
                s=s.substring(0,i+1)+s.substring(i+2);
            }else {
                break;
            }
        }
    }
    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
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
    @Test
    public void test(){
        String s="25525511135";
        List<String>li=restoreIpAddresses(s);
        System.out.println(li.toString());
    }

}
