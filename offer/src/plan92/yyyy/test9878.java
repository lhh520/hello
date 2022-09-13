package plan92.yyyy;

import org.junit.Test;

import java.util.Comparator;
import java.util.*;

public class test9878 {
    public int minOperations (String str) {

        Deque<Character>deque=new ArrayDeque<>();
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        sb2.append(str);
        int ret=0;
        while (true){
            char[]cc=sb2.toString().toCharArray();
            Arrays.sort(cc);
            sb1.append(String.valueOf(cc));
            Set<Character>set=new HashSet<>();
            int k=0;
            for(k=0;k<sb1.length();k++){
                if(!set.add(sb1.charAt(k))){
                    break;
                }
            }
            if(set.size()==sb1.length()){
                break;
            }
            sb2=new StringBuilder();
            for(int i=0;i<sb1.length()-1;){
                if(i==sb1.length()-2&&sb1.charAt(i)==sb1.charAt(i+1)){
                    sb2.append((char)(sb1.charAt(i)+1));
                }
                if(i<sb1.length()-2&&sb1.charAt(i)==sb1.charAt(i+1)){
                    i+=2;
                    sb2.append((char)(sb1.charAt(i)+1));
                    ret++;
                }else {
                    sb2.append((char)(sb1.charAt(i)));
                    i++;
                }
            }
            sb1=new StringBuilder();
        }

        return ret;
    }
    @Test
    public void test(){
        System.out.println(minOperations("abab"));
    }
}

//
//        int[]count=new int[26];
//        for(int i=0;i<str.length();i++){
//            count[str.charAt(i)-'a']++;
//        }
//        int ret=0;
//        for(int i=0;i<26;i++){
//            ret+=count[i]/2;
//        }
//        return ret;
