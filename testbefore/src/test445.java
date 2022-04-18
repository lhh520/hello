import org.junit.Test;

import java.util.Arrays;

public class test445 {
    public int findContentChildren(int[] g, int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int child=g.length,cookie=s.length;
        for(int i=0,j=0;i<child&&j<cookie;i++,j++)
        {
            while (j<cookie&&g[i]>s[j])//需求不能满足，则要持续j++
                j++;
            if(j<cookie&&g[i]<=s[j])//当饼干可以满足的时候，匹配的数量++
                count++;
        }
        return count;
    }
    @Test
    public void test()
    {
        int[] g=new int[]{1,2,3};
        int[] s=new int[]{3};
        System.out.println(findContentChildren(g,s));
    }
}
