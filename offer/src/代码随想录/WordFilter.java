package 代码随想录;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {
    Map<String, Integer> dictionary;

    public WordFilter(String[] words) {
        dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = word.length();
            for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
                for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
                    dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
                }
            }
        }
        //System.out.println(1);
    }
    public int f(String pref, String suff) {
        System.out.println(1);
        return dictionary.getOrDefault(pref + "#" + suff, -1);
    }

    public static void main(String[] args) {
        String[]words=new String[]{"apple"};
        WordFilter wordFilter = new WordFilter(words);
        wordFilter.f("a","e");
    }
}
