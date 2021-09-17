package leetcode;

import java.util.Arrays;

/**
 * 문제 링크 : https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
 */
public class binarySearch1 {

    public static void main(String[] args) {

//        int[] nums = {-1,0,3,5,9,12};
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int answer = solution(nums, target);
        System.out.println(answer);
    }

    private static int solution(int[] nums, int target) {
        int mid, start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return -1;
    }
}
