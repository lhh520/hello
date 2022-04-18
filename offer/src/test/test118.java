package test;

import org.junit.Test;

import java.util.Arrays;

public class test118 {
    public int[] findRedundantConnection(int[][] edges) {
    return null;
    }
    public int[] numberOfLines(int[] widths, String s) {
    int cur=0,line=1;

        for (int i = 0; i <s.length(); i++) {
            int len=widths[s.charAt(i)-'a'];
            cur=cur+len;
            if(cur>100)
            {
                line++;
                cur=len;
            }
        }
        return new int[]{line,cur};

    }
    @Test
    public void test()
    {
        int[] nums=new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        int[] nn=numberOfLines(nums,"bbbcccdddaaa");
        System.out.println(Arrays.toString(nn));
    }
}
