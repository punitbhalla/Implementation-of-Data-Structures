package arrays_and_strings;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = Math.min(nums1.length, nums2.length);
        int[] temp = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                temp[k++] = nums1[i];
                i++;
                j++;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        int[] result = new int[k];
        for (int s = 0; s < k; s++) {
            result[s] = temp[s];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
