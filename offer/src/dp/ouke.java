package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ouke {
    public String reverseSentence (String target) {
        // write code here
        String[]strs=target.split(" ");
        List<String>list=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            list.add(strs[i]);
        }
        Collections.reverse(list);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            String s=list.get(i);
            sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1));
            if(i!=strs.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String or=new String(str);
        //System.out.println(str==or);
        int ret=0;
        for(int i=0;i<str.length();i++){
            str=str.substring(1)+str.charAt(0);
            if(str.equals(or)){
                ret++;
            }
        }
        System.out.println(ret);
    }
    @Test
    public void test(){
        String ss="I love Java so much";
        System.out.println(reverseSentence(ss));
    }
}
