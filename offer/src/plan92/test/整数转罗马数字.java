package plan92.test;

public class 整数转罗马数字 {
    public String intToRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman=new StringBuilder();
        for(int i=0;i<values.length;i++){
            int value=values[i];
            String symbol=symbols[i];
            while (num>=values[i]){
                num-=value;
                roman.append(symbol);
            }
            if(num==0){
                break;
            }
        }
        return roman.toString();
    }
}
