package test;

import java.util.HashMap;

public class test804 {
    public int uniqueMorseRepresentations(String[] words) {
    String[] code=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String,Integer>map=new HashMap<>();
        for (int i = 0; i <words.length; i++) {
            StringBuilder sb=new StringBuilder();
            String temp=words[i];
            for(int j=0;j<temp.length();j++)
            {
                sb.append(code[temp.charAt(j)-'a']);
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
        }
        return map.size();
    }
}
