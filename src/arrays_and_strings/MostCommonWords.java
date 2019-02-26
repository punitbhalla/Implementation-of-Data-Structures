package arrays_and_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWords {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String inputString = paragraph.replaceAll("\\W+", " ").toLowerCase();
        String[] words = inputString.split(" ");
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : banned) {
            set.add(word);
        }
        String result = null;
        int max = -1;
        for (String word : words) {
            if (!set.contains(word) && !word.equals("")) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > max) {
                    result = word;
                    max = map.get(word);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
