import org.junit.Test;

public class test1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
    int[] acc=new int[26];
    String[] text11 =text.split(" ");
    for(int i=0;i<brokenLetters.length();i++)
    {
         acc[brokenLetters.charAt(i)-'a']++;
    }
    int account=0;
    for(int i=0;i<text11.length;i++)
    {
        for(int j=0;j<text11[i].length();j++)
        {
            if(acc[text11[i].charAt(j)-'a']!=0)
            {account++;
            break;
            }
        }
    }
    return text11.length-account;
    }
    @Test
    public void test()
    {
        String text = "leet code", brokenLetters = "e";
        System.out.println(canBeTypedWords(text,brokenLetters));
    }
    }

