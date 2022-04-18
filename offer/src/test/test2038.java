package test;

import org.junit.Test;

public class test2038 {
    public boolean winnerOfGame(String colors) {
    char[]chars=colors.toCharArray();
    int cntA=0,cntB=0;
    int i=0;
    while(i<colors.length()){
        int start=i,end=i;
        if(chars[i]=='A'){
            while (end < colors.length()&&chars[end] == 'A'){
                end++;
            }
            cntA = cntA + (end - start > 2 ? (end - start-2) : 0);
        }else if(chars[i]=='B'){
            while (end < colors.length()&&chars[end] == 'B') {
                end++;
            }
            cntB = cntB + (end - start > 2 ? (end - start) : 0);
        }
         i=end;
    }
    return cntA>cntB;
    }

    @Test
    public void test(){
        String colors="ABBBBBBBAAA";
        System.out.println(winnerOfGame(colors));
    }
}
