package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 向字符串添加空格 {
    public String addSpaces(String s, int[] spaces) {
        List<Character>list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        for(int i=spaces.length-1;i>=0;i--){
            list.add(spaces[i],' ');
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    @Test
    public void test(){
        String s = "LeetcodeHelpsMeLearn";
        int[]spaces =new int[]{8,13,15};
        addSpaces(s,spaces);
    }
}
