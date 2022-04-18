package test;

import org.junit.Test;

import java.util.*;

public class test500 {

    public String[] findWords(String[] words) {
        String a="qwertyuiop";
        char[] characters=a.toCharArray();
        List<Character>list1=new ArrayList<Character>();
        for(int i=0;i<characters.length;i++)
        {
            list1.add(characters[i]);
        }
        System.out.println(list1.toString());
        String a2="asdfghjkl";
        char[] characters1=a2.toCharArray();
        List<Character>list2=new ArrayList<Character>();
        for(int i=0;i<characters1.length;i++)
        {
            list2.add(characters1[i]);
        }
        System.out.println(list2.toString());
        String a3="zxcvbnm";
        char[] characters2=a3.toCharArray();
        List<Character>list3=new ArrayList<Character>();
        for(int i=0;i<characters2.length;i++)
        {
            list3.add(characters2[i]);
        }
        System.out.println(list3.toString());
        List<String>ans=new ArrayList<>();
        System.out.println(1);
        for(int i=0;i< words.length;i++)
        {
            if(col(words[i],list2)||col(words[i],list1)||col(words[i],list3))
                ans.add(words[i]);
        }
        String[] anss=new String[ans.size()];
        for(int i=0;i< ans.size();i++)
        {
            anss[i]=ans.get(i);
        }
       return anss;
    }
    public boolean col(String a,List<Character>list)
    {   //a.toLowerCase(Locale.ROOT);
        String str2=a.toLowerCase();
        for(int i=0;i<a.length();i++)
        {   char nn=str2.charAt(i);
            if(!list.contains(nn))
                return false;
        }
        return true;
    }
    @Test
    public  void test() {
        String[] words = new String[] {"Alaska","Dad","Peace"};
        String[] ans=findWords(words);
        System.out.println(ans.length);
    }
}
