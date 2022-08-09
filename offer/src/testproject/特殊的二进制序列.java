package testproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 特殊的二进制序列 {
    public String makeLargestSpecial(String s) {
        if(s.length()==0) return s;
        List<String>list=new ArrayList<>();
        char[]cs=s.toCharArray();
        for(int i=0,j=0,k=0;i<cs.length;i++){
            k+=cs[i]=='1'?1:-1;
            if(k==0){
                list.add("1"+makeLargestSpecial(s.substring(j+1,i))+"0");
                j=i+1;
            }
        }
        Collections.sort(list,(a,b)->(b+a).compareTo(a+b));
        StringBuilder sb=new StringBuilder();
        for(String str:list) sb.append(str);
        return sb.toString();
    }
}
