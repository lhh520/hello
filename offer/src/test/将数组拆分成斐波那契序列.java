package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class 将数组拆分成斐波那契序列 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer>list=new ArrayList<>();
        backtrace(num.toCharArray(),list,0);
        return list;
    }
    public boolean backtrace(char[]digit,List<Integer>res,int index){
        if(index==digit.length&&res.size()>=3){
            return true;
        }
        for(int i=index;i<digit.length;i++){
            //两位以上数字不能以0开头
            if(digit[index]=='0'&&i>index){
                break;
            }
            long num=subDigit(digit,index,i+1);
            if(num>Integer.MAX_VALUE){
                break;
            }
            int size=res.size();
            if(size>=2&&num>res.get(size-1)+res.get(size-2)){
                break;
            }
            if(size<=1||num==res.get(size-1)+res.get(size-2)){
                res.add((int)num);
                if(backtrace(digit,res,i+1)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }
    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }
    @Test
    public void test(){
        String num = "1101111";
        System.out.println(splitIntoFibonacci(num).toString());
    }

}
