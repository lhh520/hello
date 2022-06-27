package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class 重新排列句子中的单词 {
    public String arrangeWords(String text) {
        String[]strs=text.split(" ");
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return 0;
                }
                return o1.length()-o2.length();
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if(i==0){
                char[]chars=strs[i].toCharArray();
                if(Character.isLowerCase(chars[0])){
                    chars[0]= (char) (chars[0]-32);
                }
                strs[i]=String.valueOf(chars);
            }else {
                strs[i]= strs[i].toLowerCase();
            }
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    @Test
    public void test(){
        String text = "Leetcode is cool";
        System.out.println(arrangeWords(text));
    }
}
