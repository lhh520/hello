package test;

import org.junit.Test;

import java.util.Arrays;

public class test455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int sum=0;
        while (j<s.length&&i<g.length){
           while (j<s.length&&s[j]<g[i]){
               j++;
           }
           if(j<s.length&&s[j]>=g[i]){
               i++;
               j++;
               sum++;
           }
        }
        return sum;
    }
    @Test
    public void test(){
        int[]g =new int[]{1,2}, s =new int[]{1,2,3};
        System.out.println(findContentChildren(g,s));
    }
}
