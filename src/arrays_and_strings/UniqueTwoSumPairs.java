package arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTwoSumPairs {

    public static List<List<Integer>> getUniquePairs(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;


        // TODO check if all numbers are same


        while (low < high) {
            if ((arr[low] + arr[high]) == target) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[low]);
                list.add(arr[high]);
                result.add(list);
                while (low < high && arr[low] == arr[low + 1]) low++;
                while (low < high && arr[high] == arr[high - 1]) high--;
                low++;
                high--;
            } else if ((arr[low] + arr[high]) < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] arr = {-1, 2, 4, -6, 0, 1, -1, -1};
        // -6,-1,-1,-1,0,1,2,4
        int target = -2;
        System.out.println(getUniquePairs(arr, target));
    }
}
