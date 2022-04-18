import java.util.ArrayList;
import java.util.List;

public class test521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        else
            return Math.min(a.length(), b.length());
    }
    public List<Integer> grayCode(int n) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;1<i<<n;i++)
        {
        ans.add(n^(n>>1));
        }
        return ans;
    }
    }
