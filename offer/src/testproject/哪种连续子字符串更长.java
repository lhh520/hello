package testproject;

public class 哪种连续子字符串更长 {
    public boolean checkZeroOnes(String s){
        int len1 = 0, len0 = 0;
        int max1 = 0, max0 = 0;
        for (char c : s.toCharArray()) {
            if (c=='0') {
                len0++;
                len1=0;
            }else{
                len1++;
                len0=0;
            }
            max1=Math.max(len1,max1);
            max0=Math.max(len0,max0);
        }
        return max1>max0;
    }
}
