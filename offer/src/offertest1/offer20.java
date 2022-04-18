package offertest1;


import org.junit.Test;

public class offer20 {
    public boolean isNumber(String s) {
        if(s.isEmpty()||s.equals(" "))
            return false;
       return isA(s)||isB(s);
    }
    public boolean isA(String s){

        int index0=s.indexOf(".");
        if(index0!=-1)
        return false;
        if(s.startsWith("E")||s.endsWith("e")||s.startsWith("e")||s.startsWith("E"))
            return false;

        //int index1=s.indexOf("e");
        return true;
    }
    public boolean isB(String s){
        int index0=s.indexOf(".");
        if(index0==-1||(index0!=-1&&s.length()==1))
            return false;
        int sum=0;
        int sum2=0;
        int sum3=0;
        if(s.startsWith(".")||s.endsWith("."))
            return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.')
                sum++;
            if(s.charAt(i)=='+'||s.charAt(i)=='-')
                sum2++;
            if(Character.isDigit(s.charAt(i)))
                sum3++;
            if(Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i)))
                return false;
        }
        if(sum>=2||sum2>=2||sum3==0)
            return false;
        return true;
    }
    @Test
    public void test(){
        String s=" .";
        System.out.println(isNumber(s));
    }
}
