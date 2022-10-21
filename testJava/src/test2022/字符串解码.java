package test2022;
import java.util.*;
public class 字符串解码 {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        Stack<Integer>kstack=new Stack<>();
        Stack<StringBuilder>resStack=new Stack<>();
        int k=0;
        for(char c:s.toCharArray()){
            if(c=='['){
                kstack.push(k);//表示数字结束了
                resStack.push(res);//表示将上一次的数据放入其中
                //开始归位
                k=0;
                res=new StringBuilder();
            }else if(c==']'){
                int curk=kstack.pop();//弹出数字
                StringBuilder temp=new StringBuilder();
                for(int i=0;i<curk;i++){
                    temp.append(res);
                }
                res=resStack.pop().append(temp);
            }else if(c>='0'&&c<=9){
                k=c-'0'+k*10;
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
