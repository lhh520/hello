package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class 基本计算器II {
    Stack<Integer>num=new Stack<>();
    Stack<Character>op=new Stack<>();
    HashMap<Character,Integer>map=new HashMap<>();
    void eval(){
        int b=num.pop();
        int a=num.pop();
        char c=op.pop();
        int r=0;
        if(c=='+') r=a+b;
        else if(c=='-') r=a-b;
        else if(c=='*') r=a*b;
        else r=a/b;
        num.add(r);
    }
    public int calculate(String s) {
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' ') continue;
            //遇到数字
            if(c>='0'&&c<='9'){//c是数字 读取第一个连续数字
                int x=0,j=i;
                while (j<s.length()&&s.charAt(j)>='0'&&s.charAt(j)<='9'){
                    x=x*10+s.charAt(j)-'0';
                    j++;
                }
                i=j-1;
                num.add(x);//数字添加
            }else {
                while (!op.isEmpty()&&map.get(op.peek())>=map.get(c)){
                    eval();
                }
                op.add(c);
            }
        }
        while (!op.isEmpty()){
            eval();
        }
        return num.peek();
    }
    @Test
    public void test(){
        String s = "3+2*2";
        System.out.println(calculate(s));
    }
}
