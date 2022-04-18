import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testeasy {
    public int hammingWeight(int n) {
        String ans=Integer.toBinaryString(n);
        int sum=0;
        for(int i=0;i<ans.length();i++)
        {
            if(ans.charAt(i)==1)
                sum++;
        }
        return sum;
    }
}
