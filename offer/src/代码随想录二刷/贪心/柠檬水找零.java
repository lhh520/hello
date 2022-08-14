package 代码随想录二刷.贪心;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,twoty=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                five--;
                if(five<0){
                    return false;
                }
                ten++;
            }else {
                five--;
                ten--;
                if(five<0||ten<0){
                    return false;
                }
                twoty++;
            }
        }
        return true;
    }
}
