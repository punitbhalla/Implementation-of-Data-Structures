package arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumLookup = new HashMap<>();
        sumLookup.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumLookup.containsKey(sum - k)) {
                count += sumLookup.get(sum - k);
            }

            sumLookup.put(sum, sumLookup.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(subarraySum(nums, 2));
    }
}
