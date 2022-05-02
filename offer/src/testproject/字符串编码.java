package testproject;

import org.junit.Test;

import java.util.Stack;

public class 字符串编码 {
    public String decodeString(String s) {
        int k=0;
        StringBuffer res=new StringBuffer();
        Stack<Integer>kstack=new Stack<>();
        Stack<StringBuffer>restack=new Stack<>();
        System.out.println(1);
        for(char c:s.toCharArray()){
            //遇到左括号，则要重新开始计数
            //一旦遇到左括号，
            if(c=='['){
                kstack.push(k);
                restack.push(res);
                k=0;
                res=new StringBuffer();
            }
            else if(c==']'){
                int curk=kstack.pop();//弹出数字
                StringBuffer temp=new StringBuffer();
                for(int i=0;i<curk;i++){
                    temp.append(res);
                }
                //与括号外的进行合并
                res=restack.pop().append(temp);
            }else if(c>='0'&&c<='9'){
                k=c-'0'+k*10;
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
    @Test
    public void test(){
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
