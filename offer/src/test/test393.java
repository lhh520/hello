package test;

import org.junit.Test;

public class test393 {
    public boolean validUtf8(int[] data) {
        int i=0;
        while(i<data.length){
            int temp=data[i];
            String c=Integer.toBinaryString(temp);
            int n=countzero(c);
            int end=n+i;
            i++;
            while(i<end&&i<data.length){
                String ss=Integer.toBinaryString(data[i]);
                while (ss.length()<8){
                    ss="0"+ss;
                }
                if(!ss.startsWith("10")) {
                    return false;
                }
                i++;
            }

        }
        return true;
    }
    int countzero(String c){
        for(int i=0;i<c.length();i++){
            if(c.charAt(i)=='0'){
                return i;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        int[]data=new int[]{235,140,4};
        boolean a=validUtf8(data);
        System.out.println(a);
    }
}
