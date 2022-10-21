package test2022;

import java.util.Stack;

public class 字符串解码1 {
    public String decodeString(String s) {
        StringBuffer res=new StringBuffer();
        Stack<Integer>kstack=new Stack<>();
        Stack<StringBuffer>resstack=new Stack<>();
        int k=0;
        for(char c:s.toCharArray()){
            if(c=='['){//遇到左括号 先入栈 复原
                kstack.push(k);
                resstack.push(res);
                //开始归零
                k=0;
                res=new StringBuffer();
            }else if(c==']'){
                int curk=kstack.pop();//开始组装
                StringBuffer temp=new StringBuffer();
                for(int i=0;i<curk;i++){
                    temp.append(res);
                }
                res=resstack.pop().append(temp);
            }else if(c>='0'&&c<='9'){
                k=c-'0'+k*10;
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String decodeString1(String s) {
        StringBuffer res=new StringBuffer();
        Stack<Integer>kstack=new Stack<>();
        Stack<StringBuffer>resStack=new Stack<>();
        int k=0;
        for(char c:s.toCharArray()){
            if(c=='['){
                //先将数字放入其中
                kstack.push(k);
                resStack.push(res);
                //表示归位
                k=0;
                res=new StringBuffer();
            }else if(c==']'){//遇到右括号 开始整理
                int curk=kstack.pop();
                StringBuffer temp=new StringBuffer();
                for(int i=0;i<curk;i++){
                    temp.append(res);
                }
                res=resStack.pop().append(temp);
            }else if(c>='0'&&c<='9'){
                k=c-'0'+k*10;
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
