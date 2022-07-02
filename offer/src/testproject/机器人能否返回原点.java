package testproject;

import java.util.HashMap;

public class 机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int count1=0;
        int count2=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                count1++;
            }else if(moves.charAt(i)=='D'){
                count1--;
            }else if(moves.charAt(i)=='L'){
                count2++;
            }else {
                count2--;
            }
        }
        if(count1==0&&count2==0){
            return true;
        }else {
            return false;
        }
    }
}
