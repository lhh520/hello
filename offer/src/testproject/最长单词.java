package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 最长单词 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String word : words) {
            char[] cs = word.toCharArray();
            if (f(cs, 0, set)) {
                return new String(cs);
            }
        }
        return "";
    }

    private boolean f(char[] cs, int index, Set<String> set) {
        if (index == cs.length) {
            return true;
        }
        for (int i = index; i < cs.length; i++) {
            String ss=new String(cs, index, i - index + 1);
            if (set.contains(ss)) {
                if (index == 0 && i == cs.length - 1) {
                    return false;
                }
                if (f(cs, i + 1, set)) {
                    return true;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        String[]strs=new String[]{"cat","banana","dog","nana","walk","walker","dogwalker"};
        System.out.println(longestWord(strs));
    }

}
