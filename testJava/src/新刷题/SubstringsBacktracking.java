package 新刷题;

import java.util.ArrayList;
import java.util.List;

public class SubstringsBacktracking {
    public static void main(String[] args) {
        String input = "abc";

        System.out.println("All Substrings of \"" + input + "\":");
        List<String> result = findAllSubstrings(input);
        System.out.println(result);
    }

    public static List<String> findAllSubstrings(String str) {
        List<String> result = new ArrayList<>();
        backtrack(result, str, 0, "");
        return result;
    }

    private static void backtrack(List<String> result, String str, int start, String current) {
        result.add(current);

        for (int i = start; i < str.length(); i++) {
            current += str.charAt(i);
            backtrack(result, str, i + 1, current);
            current = current.substring(0, current.length() - 1);
        }
    }
}
