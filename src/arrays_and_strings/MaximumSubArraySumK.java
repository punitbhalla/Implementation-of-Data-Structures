package arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArraySumK {
    public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumLookupTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = i + 1;
            }
            if (!sumLookupTable.containsKey(sum)) {
                sumLookupTable.put(sum, i);
            }
            if (sumLookupTable.containsKey(sum - k)) {
                int index = sumLookupTable.get(sum - k);
                if (maxLength < i - index) {
                    maxLength = i - index;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(maxSubArrayLen(nums, k));
    }
}
