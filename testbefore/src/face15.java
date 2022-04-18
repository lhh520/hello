import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class face15 {
    public int[] masterMind(String solution, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < solution.length(); i++) {
            map.put(solution.charAt(i), map.getOrDefault(solution.charAt(i), 0) + 1);
        }
        int a = 0, b = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (map.containsKey(guess.charAt(i))) {
                if (map.get(guess.charAt(i)) == i)
                    a++;
                else b++;
            }

        }
        return new int[]{a, b};
    }
    @Test
    public void test()
    {
        String solution="RGBY",guess="GGRR";
        int[] ans=masterMind(solution,guess);
        System.out.println(Arrays.toString(ans));
    }
}
