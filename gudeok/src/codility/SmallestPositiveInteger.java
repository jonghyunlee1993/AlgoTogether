package codility;

import java.util.Arrays;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        int[] A = {1,3,6,4,1,2};
        System.out.println(solution(A));
    }

    public static int solution(int[] a) {
        Arrays.sort(a);
        int min = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) {
                min += 1;
            }
        }
        return min;
    }
}
