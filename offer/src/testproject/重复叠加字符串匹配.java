package testproject;

import org.junit.Test;

public class 重复叠加字符串匹配 {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int k=a.length()/b.length();
        for(int i=0;i<k;i++){
            sb.append(a);
        }
        String ans2=sb.toString()+a;
        String ans3=sb.toString()+a;
        if(sb.toString().contains(b)){
            return k;
        }else if(ans2.contains(b)){
            return k+1;
        }else if(ans3.contains(b)){
            return k+2;
        }
        return -1;
    }
    @Test
    public void test(){
        String a = "abcd", b = "cdabcdab";
        System.out.println(repeatedStringMatch(a,b));
    }
}
