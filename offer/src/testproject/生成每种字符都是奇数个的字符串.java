package testproject;

public class 生成每种字符都是奇数个的字符串 {
    public String generateTheString(int n) {
        if(n==1){
            return "a";
        }
        StringBuilder sb=new StringBuilder();
        if(n%2!=0){
            while (n-->0){
                sb.append('a');
            }
        }else {
            n=n-1;
            while (n-->0){
                sb.append('a');
            }
            sb.append('b');
        }
        return sb.toString();
    }
}
