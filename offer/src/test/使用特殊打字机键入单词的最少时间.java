package test;

import org.junit.Test;

public class 使用特殊打字机键入单词的最少时间 {
    public int minTimeToType(String word) {
        int res = 0;
        int prev = 0;   // 当前位置
        for (char ch : word.toCharArray()){
            // 计算键入每个字符的最小耗时并更新当前位置
            int curr = ch - 'a';
            res += 1 + Math.min(Math.abs(curr - prev), 26 - Math.abs(curr - prev));
            prev = curr;
        }
        return res;
    }
    @Test
    public void test(){
        String word = "abc";
        System.out.println(minTimeToType(word));
    }
}
