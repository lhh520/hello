package testproject;

public class 反转两次的数字 {
    public boolean isSameAfterReversals(int num) {
        String s=Integer.toString(num);
        return s.endsWith("0");
    }
}
