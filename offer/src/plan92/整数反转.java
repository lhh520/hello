package plan92;

public class 整数反转 {
    public int reverse(int x) {
        String str=String.valueOf(x);
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        return Integer.valueOf(sb.reverse().toString());
    }
}
