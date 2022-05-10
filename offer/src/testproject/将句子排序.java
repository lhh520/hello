package testproject;

import org.junit.Test;

import java.util.*;

public class 将句子排序 {
    public String sortSentence(String s) {
        String[]strs=s.split(" ");
        List<String>list=new ArrayList<>(Arrays.asList(strs));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a=Integer.parseInt(o1.substring(o1.length()-1,o1.length()));
                int b=Integer.parseInt(o2.substring(o2.length()-1,o2.length()));

                return a-b;
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i).substring(0,list.get(i).length()-1));
            if(i<list.size()-1)
            sb.append(" ");
        }
        System.out.println(list.toString());

        return sb.toString();
    }
    @Test
    public void test(){
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
