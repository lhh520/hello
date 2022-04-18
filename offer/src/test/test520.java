package test;

public class test520 {
    public boolean detectCapitalUse(String word) {
        if(word.length()<=1)
            return true;
    char[] chars=word.toCharArray();
    if(Character.isUpperCase(chars[0]))
    {
        if(Character.isUpperCase(chars[1]))
        { for(int i=0;i< chars.length;i++)
            {
                if(!Character.isUpperCase(chars[i]))
                    return false;
            }
            return true;
        }
        for(int i=1;i< chars.length;i++)
        {
            if(Character.isUpperCase(chars[i]))
                return false;
        }
        return true;
    }
        for(int i=0;i< chars.length;i++)
        {
            if(Character.isUpperCase(chars[i]))
                return false;
        }
        return true;
    }
}
