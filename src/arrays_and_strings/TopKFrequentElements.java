package arrays_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> resultantList = new ArrayList<>();
        List<List<Integer>> bucket = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
            bucket.add(i, null);
        }
        bucket.add(nums.length, null);
        for (Map.Entry<Integer, Integer> me : numMap.entrySet()) {
            Integer freq = numMap.get(me.getKey());
            if (bucket.get(freq) != null) {
                bucket.get(freq).add(me.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(me.getKey());
                bucket.set(freq, list);
            }
        }

        for (int i = bucket.size() - 1; i > 0 && resultantList.size() < k; i--) {
            if (bucket.get(i) != null) {
                for (Integer e : bucket.get(i)) {
                    resultantList.add(e);
                }
            }
        }
        return resultantList.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }
}
