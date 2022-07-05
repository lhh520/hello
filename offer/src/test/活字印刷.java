package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 活字印刷 {
    int ans=0;
    boolean[]used;
    public int numTilePossibilities(String tiles) {
        //子序列
        char[]chars=tiles.toCharArray();
        used=new boolean[chars.length];
        Arrays.sort(chars);
        backtrace(chars,0);
        return ans;
    }
    public void backtrace(char[]chars,int startIndex){


        if(startIndex>=chars.length){
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0&&chars[i]==chars[i-1]&&!used[i-1]){
                continue;
            }

            used[i]=true;
            ans++;
            backtrace(chars,startIndex+1);

            used[i]=false;
        }
    }
    @Test
    public void test(){
        String ss="AAB";
        System.out.println(numTilePossibilities(ss));
    }
}
