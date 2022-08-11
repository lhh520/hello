package stack;

import org.junit.Test;

import java.util.*;

public class 字符串解码 {
    public String decodeString(String s) {
        StringBuffer res=new StringBuffer();
        Stack<Integer>kstack=new Stack<>();
        Stack<StringBuffer>restack=new Stack<>();
        int k=0;
        for(char c:s.toCharArray()){
            if(c=='['){
                kstack.push(k);//表示数字结束了
                restack.push(res);//表示将上一次的数据放入其中
                k=0;//表示归位
                res=new StringBuffer();
            }else if(c==']'){//如果遇到右括号
                int curk=kstack.pop();//表示弹出数字
                StringBuffer temp=new StringBuffer();
                for(int i=0;i<curk;i++){
                    temp.append(res);
                }
                res=restack.pop().append(temp);
            }else if(c>='0'&&c<='9'){
                k=c-'0'+k*10;
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
    //
    public static String decodeString1(String s) {
        char[] chars = s.toCharArray();
        //数字栈
        Stack<Integer> numStack = new Stack<>();
        //字符串栈
        Stack<String> strStack = new Stack<>();
        //程序运行时当做[]中的字母；结束时用作结果
        StringBuilder str = new StringBuilder();
        //左括号 [ 前的数字
        int num = 0;

        //分四种情况处理，数字、字母、左括号 [、右括号 ]
        for (char c : chars) {
            if ('0' <=  c && c <= '9') {
                //数学公式，题目中数字不一定是个位数
                //如：32[a]，当 c = 2 时， num = 3 * 10 + 2;
                num = num * 10 + Integer.parseInt(c+"");
            } else if (c == '[') {
                //遇到左括号 [ 时，将数字和字母进栈
                numStack.push(Integer.valueOf(String.valueOf(num)));
                //首次进栈时是一个空字符串，和数字并不是对齐的,所以当找到最后的字母时，并不需要进栈
                strStack.push(str.toString());
                //记得重置
                num = 0;
                str = new StringBuilder();
            }else if (c == ']'){
                //这里是重要步骤！！！

                StringBuilder tmp = new StringBuilder();
                Integer pop = numStack.pop();
                // 这种更好理解！！
                for (int i = 0; i < pop; i++) {
                    tmp.append(str);
                }
                // 这种更简化！！用 StringBuilder 的 repeat 重复次数
                //tmp.append(String.valueOf(str).repeat(Math.max(0, pop)));

                //取出字母栈的栈顶，拼接组合好的字母，配合上一步的循环
                //如：3[a2[bc]] 结果：a bcbc  a bcbc  a bcbc
                //1、弹出数字 2，先走上面一步循环两遍 str = bc，得到 bcbc
                //2、弹出字母 a，拼接，得到 str = abcbc
                //3、重复步骤 1
                str = new StringBuilder(strStack.pop()).append(tmp);
            }else {
                str.append(c);
            }
        }
        return str.toString();
    }


    @Test
    public void test(){
        String s = "1[a]2[c]3[d]";
        System.out.println(decodeString1(s));
    }
}
