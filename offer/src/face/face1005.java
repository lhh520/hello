package face;

public class face1005 {
    public int findString(String[] words, String s) {
    for(int i=0;i<words.length;i++)
    {
        if(words.length!=0&&s.equals(words[i]))
            return i;
    }
    return -1;
    }
}
