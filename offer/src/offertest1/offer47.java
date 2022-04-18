package offertest1;

import org.junit.Test;

public class offer47 {
    public int strToInt(String str) {
        int index1=0,index2=0;
        for(int i=0;i<str.length();i++){
            if(!(str.charAt(i) ==' ')){
                index1=i;
                break;
            }

        }
        if(!(Character.isDigit(str.charAt(index1))||str.charAt(index1) =='+'||str.charAt(index1) =='-'))
            return 0;
        //
        for(int i=index1+1;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                index2=i;
                break;
            }
        }
        if(index2==0)
            index2=str.length();
        //System.out.println(index1+"   "+index2);
        //
        String s=str.substring(index1,index2);
        //System.out.println(s);
        int a;
        try {
            a=Integer.parseInt(s);
        }catch (Exception e){
            if(s.startsWith("-"))
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }

        return a;
    }
    @Test
    public void test(){
        String str="-91283472332";
        System.out.println(strToInt(str));
    }

}
