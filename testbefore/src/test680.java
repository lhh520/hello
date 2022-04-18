import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test680 {
    public boolean validPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {


            int temp = entry.getValue();
            if (temp % 2 != 0)
                count++;
        }
        if (count <= 2)
            return true;
        else
            return false;
    }

    @Test
    public void test()
    {  String t="tebbem";
        System.out.println(validPalindrome(t));
    }
}
