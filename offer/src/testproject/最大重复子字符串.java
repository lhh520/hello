package testproject;

import org.junit.Test;

import java.util.Arrays;

public class 最大重复子字符串 {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;


    }
    @Test
    public void test(){
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        System.out.println(maxRepeating(sequence,word));
    }
}
