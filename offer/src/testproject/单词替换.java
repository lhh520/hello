package testproject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[]strs=sentence.split(" ");



        StringBuilder sb=new StringBuilder();

        for(int i=0;i<strs.length;i++){
            boolean flag=false;
            for(int j=0;j<dictionary.size();j++){
                if(strs[i].startsWith(dictionary.get(j))){
                    sb.append(dictionary.get(j));
                    flag=true;
                    break;
                }
            }
            if(!flag){
                sb.append(strs[i]);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public String replaceWords1(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root: roots) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }
    @Test
    public void test(){
        String[]dictionary =new String[]{"catt","cat","bat","rat"};
        String sentence =  "the cattle was rattled by the battery";
        List<String>list=new ArrayList<>();
        for(int i=0;i<dictionary.length;i++){
            list.add(dictionary[i]);
        }
        System.out.println(replaceWords1(list,sentence));
    }
}
