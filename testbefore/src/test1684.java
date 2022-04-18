import java.util.HashSet;
import java.util.Set;

public class test1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character>set=new HashSet<>();
        int count=0;
        for(int i=0;i<allowed.length();i++)
        {
            set.add(allowed.charAt(i));
        }
        //
        for(int i=0;i<words.length;i++)
        {
            char[] temp=words[i].toCharArray();
            int j=0;
            for(j=0;j<temp.length;j++)
            {
                if(!set.contains(temp[j]))
                    break;
            }
            if(j==temp.length)
                count++;
        }
        return count;
    }
}
