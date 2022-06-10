package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 山羊拉丁文 {
    public String toGoatLatin(String sentence) {
        String[]nn=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        Set<Character> vowels = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};


        for(int i=0;i<nn.length;i++){
            if(vowels.contains(nn[i].charAt(0))){
                sb.append(nn[i]);
                sb.append("ma");
            }else {
                sb.append(nn[i].substring(1)+nn[i].charAt(0));
            }
            for(int j=0;j<i+1;j++){
                sb.append("a");
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    @Test
    public void test(){
        //sentence = "I speak Goat Latin"
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
