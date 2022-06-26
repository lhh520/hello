package testproject;

public class 字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        String ss=s2+s2;
        if(ss.contains(s1)){
            return true;
        }
        return false;
    }
}
