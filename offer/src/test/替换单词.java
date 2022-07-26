package test;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 替换单词 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[]strs=sentence.split(" ");
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;i++){
            String st=strs[i];
            boolean flag=false;
            for(int j=0;j<dictionary.size();j++){
                if(st.startsWith(dictionary.get(j))){
                    flag=true;
                    sb.append(dictionary.get(j));
                    break;
                }
            }
            if(!flag){
                sb.append(st);
            }
            if(i!=strs.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String[]dictionary =new String[]{"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";

    }
}
