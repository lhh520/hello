import org.junit.Test;

public class test520 {
    public boolean detectCapitalUse(String word) {
        if(word.length()==0)
            return true;
    if(word.charAt(0)>='a'&&word.charAt(0)<'z')
    {
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z')
                return false;
        }
        return true;
    }
    if(word.charAt(1)>='A'&&word.charAt(1)<='Z')
    {
        for(int i=1;i<word.length();i++)
        {
            if(word.charAt(0)>='a'&&word.charAt(0)<'z')
                return false;
        }
        return true;
    }
        if(word.charAt(1)>='a'&&word.charAt(1)<='z')
        {
            for(int i=1;i<word.length();i++)
            {
                if(word.charAt(i)>='A'&&word.charAt(i)<='Z')
                    return false;
            }
            return true;
        }
        return false;
    }
    @Test
    public void test()
    {
        String word="ads";
        System.out.println(detectCapitalUse(word));
    }
}
