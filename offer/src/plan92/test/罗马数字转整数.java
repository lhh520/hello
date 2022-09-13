package plan92.test;

public class 罗马数字转整数 {
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s){
        int sum=0;
        int PreNum=getValue(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int num=getValue(s.charAt(i));
            if(PreNum<num){
                sum-=PreNum;
            }else {
                sum+=PreNum;
            }
            PreNum=num;
        }
        sum+=PreNum;
        return sum;
    }
}
