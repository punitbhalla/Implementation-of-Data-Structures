package arrays_and_strings;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhone {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> combinations = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        String[] lookup = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations.offer("");
        while (combinations.peek().length() != digits.length()) {
            String partialString = combinations.poll();
            String mappString = lookup[digits.charAt(partialString.length()) - '0'];
            for (char ch : mappString.toCharArray()) {
                combinations.offer(partialString + ch);
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
