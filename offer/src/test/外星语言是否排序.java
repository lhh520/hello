package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 外星语言是否排序 {
    String order;
    public boolean isAlienSorted(String[] words, String order) {
        String[]copy=words.clone();
        this.order=order;
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i=0,j=0;
                while(i<o1.length()&&j<o2.length()){
                    int c1=order.indexOf(o1.charAt(i));
                    int c2=order.indexOf(o2.charAt(j));

                    if(c1!=c2){
                        return c1-c2;
                    }
                    i++;
                    j++;
                }
                return o1.length()-o2.length();
            }
        });
        for(int i=0;i<copy.length;i++){
            if(!words[i].equals(copy[i])){
                return false;
            }
        }
        //System.out.println(Arrays.toString(copy));
        return true;
    }
    //words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    @Test
    public void test(){
      String[]words=new String[]{"apple","app"};
      String order = "abcdefghijklmnopqrstuvwxyz";
      System.out.println(isAlienSorted(words,order));
    }
}
