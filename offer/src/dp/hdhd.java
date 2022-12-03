package dp;

import org.junit.Test;

public class hdhd {
    public int count (String s) {
        // write code here
        String[]strings=s.split(" ");
        //"can can need u show show way"
        int count1=0;
        for(int i=0;i<strings.length-2;i++){
            String s1=strings[i];
            String s2=strings[i+1];
            String s3=strings[i+2];
            if(s1.equals(s2)&&!s1.equals(s3)){
                count1++;
            }
        }
        return count1;
    }
    @Test
    public void test(){
        System.out.println(count("can can need u show show way"));
    }
}
