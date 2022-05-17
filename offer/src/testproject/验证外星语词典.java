package testproject;

import org.junit.Test;

import java.util.*;

public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        List<String>list=new ArrayList<>(Arrays.asList(words));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return 0;
                for(int i=0,j=0;i<o1.length()&&j<o2.length();i++,j++){
                    char c1=o1.charAt(i);
                    char c2=o2.charAt(j);
                    if(map.get(c1)!=map.get(c2)) {
                        return map.get(c1)-map.get(c2);
                    }
                }
                return o1.length()>o2.length()?-1:1;
            }
        });
        System.out.println(list.toString());
        for(int i=0;i<list.size();i++){
            if(!list.get(i).equals(words[i])){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        //["word","world","row"]
        //"worldabcefghijkmnpqstuvxyz"
       String[]words=new String[]{"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words,order));
    }
}
