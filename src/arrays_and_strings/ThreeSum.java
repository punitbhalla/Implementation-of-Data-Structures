package arrays_and_strings;

import java.util.*;

public class ThreeSum {
    static class Triplet {
        private final int first;
        private final int second;
        private final int third;
        private final int[] sorted;

        public Triplet(int a, int b, int c) {
            this.first = a;
            this.second = b;
            this.third = c;
            this.sorted = new int[]{a, b, c};
            // Arrays.sort(this.sorted);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            return o instanceof Triplet && Arrays.equals(this.sorted, ((Triplet) o).sorted);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(this.sorted);
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Triplet> set = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    Triplet t = new Triplet(nums[i], nums[low], nums[high]);
                    if (!set.contains(t)) {
                        list.add(t.first);
                        list.add(t.second);
                        list.add(t.third);
                        result.add(list);
                        set.add(t);
                    }
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < -nums[i]) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int []{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
