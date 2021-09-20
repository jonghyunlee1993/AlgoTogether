package leetcode;

public class binarySearch2 {

    public static void main(String[] args) {
        int input = 8;

        int answer = solution(input);
        System.out.println(answer);
    }

    private static int solution(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
