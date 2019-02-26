package arrays_and_strings;

import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new HashMap<>();
        TreeMap<Integer, TreeSet<String>> bucket = new TreeMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int freq = entry.getValue();
            if (bucket.get(freq) == null) {
                TreeSet<String> set = new TreeSet<>();
                set.add(entry.getKey());
                bucket.put(freq, set);
            } else {
                bucket.get(freq).add(entry.getKey());
            }
        }
        System.out.println(bucket);
        Set<Integer> freqKeys = bucket.descendingKeySet();
        for (Integer freq : freqKeys) {
            for (String str : bucket.get(freq)) {
                result.add(str);
            }
        }

        return result.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
}
