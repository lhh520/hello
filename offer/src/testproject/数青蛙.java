package testproject;

import org.junit.Test;

public class 数青蛙 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        //记录数量和
        int num=0,max=0;
        int size=croakOfFrogs.length();
        int[]count=new int[5];
        for(int i=0;i<croakOfFrogs.length();i++){
            char c=croakOfFrogs.charAt(i);
            if(c=='c'){
                num++;
                max=Math.max(max,num);
                count[0]++;
            }else if(c=='r'){
                count[1]++;
                if(count[1]>count[0]){
                    return -1;
                }
            }else if(c=='o'){
                count[2]++;
                if(count[2]>count[1]){
                    return -1;
                }
            }else if(c=='a'){
                count[3]++;
                if(count[3]>count[2]){
                    return -1;
                }
            }else if(c=='k'){
                num--;
                count[4]++;
                if(count[4]>count[3]){
                    return -1;
                }
            }
        }
        if (count[0] != count[1] || count[0] != count[2] || count[0] != count[3] || count[0] != count[4]){
            return -1;
        }
        return max;
    }
    @Test
    public void test(){
        String croakOfFrogs = "croakcroak";
        System.out.println(minNumberOfFrogs(croakOfFrogs));
    }
}
