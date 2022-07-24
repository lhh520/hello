package 代码随想录二刷.字符串;

import org.junit.Test;

public class 替换空格 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
    @Test
    public void test(){
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
