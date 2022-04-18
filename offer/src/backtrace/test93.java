package backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test93 {
    //输入：s = "25525511135"
    //输出：["255.255.11.135","255.255.111.35"]
    List<List<String>>lists=new ArrayList<>();
    List<String>list=new ArrayList<>();
    List<String>ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        System.out.println(s);
        if(s.length()==0||s.length()>12){
            return list;
        }
        backtrace(s,0,0);
        return list;
    }
    public void backtrace(String s,int index,int point){
        if(point==3){//如果句号用完，判定最后一个满足，则输出
            if(check(s,index,s.length()-1))
                list.add(s);
            return;
        }
        for(int i=index;i<s.length();i++){
            if(check(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                point++;
                backtrace(s,i+2,point);
                point--;
                s=s.substring(0,i+1)+s.substring(i+2);
            }
            else {
                break;
            }
        }
    }
    public boolean check(String s,int start,int end){
        if(start>end)
            return false;
        if(s.charAt(start)=='0'&&start!=end){
            return false;
        }
        int num=0;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)>'9'||s.charAt(i)<0)//遇到了非数字
                return false;
            num=num*10+(s.charAt(i)-'0');
            if(num>255)
                return false;
        }
        return true;
    }
    @Test
    public void test(){
        List<String>ll=restoreIpAddresses("25525511135");
        System.out.println(ll.toString());
    }
}
