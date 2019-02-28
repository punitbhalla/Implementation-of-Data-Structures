package arrays_and_strings;

public class SearchElementRotatedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    private static int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid]) {
                return search(nums, low, mid, target);
            } else {
                return search(nums, mid + 1, high, target);
            }

        } else {
            if (target >= nums[mid + 1] && target <= nums[high]) {
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int target = 5;
        System.out.println(search(nums, target));
    }
}
