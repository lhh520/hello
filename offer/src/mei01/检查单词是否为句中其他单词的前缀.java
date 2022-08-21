package mei01;

import org.junit.Test;

public class 检查单词是否为句中其他单词的前缀 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[]strs=sentence.split(" ");
        for(int i=0;i<strs.length;i++){
            if(strs[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
    @Test
    public void test(){
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence,searchWord));
    }
}
