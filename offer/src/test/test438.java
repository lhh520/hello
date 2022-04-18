package test;

import org.junit.Test;

import java.util.*;

public class test438 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strings=text.split(" ");
        int len=strings.length;
        List<String>list=new ArrayList<>();
        for (int i = 0; i <len-2; i++) {
           if(strings[i].equals(first)&&strings[i+1].equals(second))
           {
               list.add(strings[i+2]);
           }
        }
        String[] anss=new String[list.size()];
        for (int i = 0; i < anss.length; i++) {
            anss[i]=list.get(i);
        }
        return anss;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list=new ArrayList<>();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<p.length();i++){
            set.add(p.charAt(i));
        }
        for(int i=0;i<s.length()-p.length()+1;i++){

            if(set.contains(s.charAt(i))){
                int j;
                Set<Character>set2=new HashSet<>();
                for(j=i;j<i+p.length();j++){
                    if(!set.contains(s.charAt(j))||!set2.add(s.charAt(j))){
                        break;
                    }
                }
                if(j==i+p.length())
                    list.add(i);
            }
        }
        return list;

    }
    //
    public List<Integer> findAnagrams1(String s, String p){
      int sLen=s.length(),pLen=p.length();
      if(sLen<pLen){
          return new ArrayList<>();
      }
      List<Integer>ans=new ArrayList<>();
      int[]sCount=new int[26];
      int[]pCount=new int[26];
      //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
      for(int i=0;i<pLen;i++){
          ++sCount[s.charAt(i)-'a'];
          ++pCount[p.charAt(i)-'a'];
      }
      if(Arrays.equals(sCount,pCount)){
          ans.add(0);
      }
        for(int i=0;i<sLen-pLen;i++){ //i是滑动前的首位
            --sCount[s.charAt(i) -'a'];       //将滑动前首位的词频删去
            ++sCount[s.charAt(i+pLen) -'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }
        }
        return ans;

    }
    @Test
    public void test(){
        String  s = "abab", p = "ab";
        List<Integer>list=findAnagrams(s,p);
        System.out.println(list.toString());
    }
}
