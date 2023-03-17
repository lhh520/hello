import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        if(strs.length==1){
            return strs[0];
        }
        int i=0;
        for(i=0;i<strs[0].length();i++){
            int flag=0;
            for(int j=1;j<strs.length;j++){
                char c=strs[j].charAt(i);
                if(c!=strs[0].charAt(i)){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        return strs[0].substring(0,i);
    }
    @Test
    public void test(){
        String[]strs=new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
