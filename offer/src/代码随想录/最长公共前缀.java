package 代码随想录;

import org.junit.Test;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            min=Math.min(min,strs[i].length());
        }
        System.out.println(1);
        for(int i=0;i<min;i++){
            char c=strs[0].charAt(i);
            boolean flag=false;
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
            sb.append(c);
        }
        if(sb.length()<=0){
            return "";
        }
        return sb.toString();
    }
    public String longestCommonPrefix2(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    @Test
    public void test(){
        String[]strs =new String[]{""};
        System.out.println(longestCommonPrefix(strs));
    }
}
