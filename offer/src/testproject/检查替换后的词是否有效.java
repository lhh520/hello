package testproject;

import org.junit.Test;

public class 检查替换后的词是否有效 {
    public boolean isValid(String s) {
        //反向考虑 可以不断的删除abc
        if(s.length()%3!=0){
            return false;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        System.out.println(1);
        while (true){
            if(sb.length()==0){
                return true;
            }
            if(sb.length()==3&&!sb.toString().equals("abc")){
                return false;
            }
            boolean flag=false;
            for(int i=0;i<sb.length()-2;i++){
                if(sb.charAt(i)=='a'&&sb.charAt(i+1)=='b'&&sb.charAt(i+2)=='c'){
                    sb.delete(i,i+3);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
    }
    @Test
    public void test(){
        String str="aababcbccabc";
        System.out.println(isValid(str));
    }
}
