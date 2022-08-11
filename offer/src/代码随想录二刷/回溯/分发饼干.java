package 代码随想录二刷.回溯;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);//孩子的胃口
        Arrays.sort(s);//饼干大小
        int i=0,j=0;
        int sum=0;
        while (i<g.length&&j<s.length){
            while (j<s.length&&s[j]<g[i]){
                j++;
            }
            if(j<s.length&&g[i]<=s[j]){
                i++;
                j++;
                sum++;
            }
        }
        return sum;
    }
}
