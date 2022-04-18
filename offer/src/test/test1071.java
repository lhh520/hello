package test;

import org.junit.Test;

public class test1071 {
    public String gcdOfStrings(String str1, String str2) {
    int len1=str1.length(),len2=str2.length();
        for (int i = Math.min(len1,len2); i >=1 ; i--) {
            if(len1%i==0&&len2%i==0)
            {
                String X=str1.substring(0,i);
                if(check(X,str1)&&check(X,str2))
                    return X;
            }
        }
        return "";
    }
    public boolean check(String str1, String str2)
    {
        int lenX=str2.length()/str1.length();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=lenX; i++) {
            sb.append(str1);
        }
        return sb.toString().equals(str2);
    }
    public String removeOuterParentheses(String s) {
    int left=0;
    StringBuilder res=new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i)=='('&&left++>0)
                res.append('(');
            if(s.charAt(i)==')'&&--left>0)
                res.append(')');
        }
        return res.toString();
    }
    @Test
    public void test()
    {
        String ans="ABCABC",ans2="ABC";
        System.out.println(gcdOfStrings(ans,ans2));
    }
}
