package testproject;

import org.junit.Test;

public class 按键持续时间最长的键 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int pre=0;
        char c='*';
        int len=0;
        for(int i=0;i<releaseTimes.length;i++){
            if(c=='*'){
                c=keysPressed.charAt(i);
                len=releaseTimes[i]-pre;
                pre=releaseTimes[i];
                continue;
            }
            if((releaseTimes[i]-pre)>len||(releaseTimes[i]-pre)==len&&keysPressed.charAt(i)>c){
                 c=keysPressed.charAt(i);
                 len=releaseTimes[i]-pre;
                 pre=releaseTimes[i];
            }else {
                pre=releaseTimes[i];
            }
        }
        return c;
    }
    @Test
    public void test(){
        //releaseTimes = [12,23,36,46,62], keysPressed = "suda"
        int[]releaseTimes =new int[]{9,29,49,50};
        String keysPressed = "cbcd";
        System.out.println(slowestKey(releaseTimes,keysPressed));
    }
}
