package stack;

public class 字母在字符串中的百分比 {
    public int percentageLetter(String s, char letter) {
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter){
                num++;
            }
        }
        return num*100/s.length();
    }
}
