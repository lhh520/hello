package testproject;

import org.junit.Test;

import java.util.*;

public class 复原IP {
    List<String>list=new ArrayList<>();
    Deque<String>deque=new ArrayDeque<>(4);
    public List<String> restoreIpAddresses(String s) {
        backtrace(s,0,4);
        return list;
    }
    public void backtrace(String s,int index,int reside){
        if(index==s.length()){
            if(reside==0){
                list.add(String.join(".",deque));
            }
            return;
        }
        //
        for(int i=index;i<index+3;i++){
            if(i>=s.length()){
                break;
            }
            //剪枝算法，剩余的长度过长，本次不应该进行
            if(s.length()-i>reside*3){
                continue;
            }
            if(judgeNumber(s,index,i)){//如果已经满足条件
                deque.addLast(s.substring(index,i+1));
                backtrace(s,i+1,reside-1);
                deque.removeLast();
            }
        }
    }
    public boolean judgeNumber(String s, int left, int right){
        int len = right - left + 1;
        //当前为0开头的且长度大于1的数字需要剪枝
        if(len>1 && s.charAt(left)=='0')
            return false;
        //将当前截取的字符串转化成数字
        int res = len<=0 ? 0 : Integer.parseInt(s.substring(left, right+1));
        //判断截取到的数字是否符合
        return res>=0 && res<=255;
    }
    @Test
    public void test(){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
