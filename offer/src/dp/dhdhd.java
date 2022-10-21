package dp;
import org.junit.Test;

import java.util.*;
public class dhdhd {
    public String solve (String str) {
        // write code here
        if(str==null||str.length()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        sb.append(sb);
        return sb.reverse().toString();
    }

    public String[] chkBlood(String father, String mother) {
        Map<String,String[]>map=new HashMap<>();
        map.put("OO",new String[]{"O"});
        map.put("AO",new String[]{"A","O"});
        map.put("AA",new String[]{"A","O"});
        map.put("AB",new String[]{"A","B","AB","O"});
        map.put("AAB",new String[]{"A","B","AB"});
        map.put("BO",new String[]{"B","O"});
        map.put("BB",new String[]{"B","O"});
        map.put("BAB",new String[]{"A","B","AB"});
        map.put("ABO",new String[]{"A","B"});
        map.put("ABAB",new String[]{"A","B","AB"});
        String str1=father+mother;
        String str2=mother+father;
        if(map.containsKey(str1)){
            String[]str=map.get(str1);
            Arrays.sort(str);
            return str;
        }else {
            String[]str=map.get(str2);
            Arrays.sort(str);
            return str;
        }
    }

    public int countWays(int n) {
        int[]dp=new int[10000];
        int a=1,b=2,c=4;
        if(n<1){
            return 0;
        }
        if(n==1) return a;
        if(n==2) return b;
        if(n==3) return c;
        //long mod=10000000007;
        for(int i=4;i<=n;i++){
            int temp=((a+b)%1000000007+c)%1000000007;
            a=b;
            b=c;
            c=temp;
        }
        return c;
    }
    @Test
    public void test(){
        String[]gg=chkBlood("A","A");
        System.out.println(countWays(4));
    }
}
