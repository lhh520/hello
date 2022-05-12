package testproject;

import org.junit.Test;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int i=0,j=0;
        int count=0;
        while (i<s.length&&j<g.length){
            while(j<g.length&&s[j]<g[i]){
                j++;
            }
            if(j<g.length&&s[j]>=g[i]){
                j++;
                i++;
                count++;
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[]g =new int[]{1,2,3};
        int[]s =new int[]{1,1};
        System.out.println(findContentChildren(s,g));
    }
}
