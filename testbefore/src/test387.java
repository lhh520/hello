import org.junit.Test;

public class test387 {
    public boolean checkRecord(String s) {
    char[] ss=s.toCharArray();
    int count1=0,count2=0;
    for(int i=0;i<s.length();i++)
    {
        if(s.charAt(i)=='A')
            count1++;
        if(count1>=2)
            return false;
    }
        for(int i=0;i<s.length()-3;i++)
        {
            if(s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L')
                return false;

        }
    return true;
    }
    public int firstUniqChar(String s) {
    char[]ss=new char[s.length()];
    int[]num=new int[26];
    ss=s.toCharArray();
    for(int i=0;i<ss.length;i++)
    {
        num[ss[i]-'a']++;
    }
    char t = 'a';
        for (int i = 0; i < s.length(); i++) {
            if (num[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }

    return -1;
    }
    @Test
    public void test()
    {
        String s="leetcode";
        System.out.println(firstUniqChar(s));
    }
}
