package testproject;

public class 平方数之和 {
    public boolean judgeSquareSum(int c) {
        for(long a=0;a*a<c;a++){
            double b=Math.sqrt(c-a*a);
            if(b==(int)b){
                return true;
            }
        }
        return false;
    }
}
