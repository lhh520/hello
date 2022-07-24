package testproject;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 第一个出现两次的字母 {
    public char repeatedCharacter(String s) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!set.add(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return '*';
    }
}
