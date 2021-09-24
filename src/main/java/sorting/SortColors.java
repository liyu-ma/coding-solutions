package sorting;

import java.util.Arrays;

public class SortColors {

//    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//    Code a one-pass algorithm using only constant extra space

    /** Idea: always swap 0 to left, 2 to right **/
    public static void sortColors(int[] nums) {
        // [0, 1, 1, 1, 0, 0, 2]
        // 0.   1 1 1 0 0 2
        // 0    0.1 1 1 0 2
        //.0.   0 0 1 1 1 2

        // 2 0 1
        // 1 0    2
        // k l.   2

        int k = -1; // track pos of 1
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == 0) {
                if (k >= 0) {
                    swap(nums, l, k);
                    if (nums[k+1] == 1) k++;
                    else k = l;
                }
                l++;
            } else if (nums[l] == 1) {
                if (k < 0) k = l;
                l++;
            } else {  // 2
                swap(nums, l , r);
                r--;
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 0, 2 };

        sortColors(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
