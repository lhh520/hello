package test;

import org.junit.Test;

import java.util.Arrays;

public class 删列造序 {
    public int minDeletionSize(String[] strs) {
        int m=strs.length;
        int n=strs[0].length();
        char[][]str=new char[n][m];

        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                str[i][j]=strs[j].charAt(i);
            }
        }
        int count=0;
        if(str.length==1){
            return 0;
        }
        for(int i=0;i<str.length;i++){
            for(int j=1;j<str[0].length;j++){
                if(str[i][j]<str[i][j-1]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    @Test
    public void test(){
        String[] strs =new String[] {"cba","daf","ghi"};
        int ans=minDeletionSize(strs);
        System.out.println(ans);
    }

}
