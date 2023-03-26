package labuladong;

import org.junit.Test;

public class qunaer02 {
    public int compareVersion (String version1, String version2) {
        if(version1.equals("")&&version2.equals("")){
            return 0;
        }
        String s1=getUnix(version1);
        String s2=getUnix(version2);
        return s1.compareTo(s2);
    }
    public String getUnix(String s){
        String[]str1=s.split("\\.");
        if(str1.length==0){
            if(Is(str1[0])){
                return "0";
            }else {
                return s;
            }
        }

        StringBuffer sb1=new StringBuffer();

        if(Is(str1[str1.length-1])){
            for(int i=0;i<str1.length-1;i++){
                sb1.append(Integer.valueOf(str1[i]));
            }
        }else {
            for(int i=0;i<str1.length;i++){
                sb1.append(Integer.valueOf(str1[i]));
            }
        }
        return sb1.toString();
    }
    public boolean Is(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(compareVersion("assa","1"));
        System.out.println("HuangJiaTongHuaShun");
    }
}
