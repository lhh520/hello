package testproject;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 复原IP地址 {
    List<String>res=new ArrayList<>();
    Deque<String> path = new ArrayDeque<>(4);
    public List<String> restoreIpAddresses(String s) {
        backtrace(s,0,4);
        return res;
    }
    public void backtrace(String s,int begin,int reside){
        if(begin == s.length()){
            //当遍历到最后一个字符且剩余段数为0时，将此时的path添加到结果中
            if(reside==0){
                res.add(String.join(".", path));
            }
            return;
        }
        for(int i=begin;i<begin+3;i++){
            if(i>=s.length()){
                break;
            }
            //进行
            if(s.length()-i>reside*3){
                continue;
            }
            if(judgeNumber(s,begin,i)){
                String cur=s.substring(begin,i+1);
                path.addLast(cur);
                backtrace(s,i+1,reside-1);
                path.removeLast();
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
        System.out.println(restoreIpAddresses(s).toString());
    }
}
