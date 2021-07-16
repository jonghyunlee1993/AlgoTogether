package codility;

import java.util.Arrays;

public class Y_3 {

    public static void main(String[] args) {
        int[] A = {1,2,1};
//        int[] A = {2,1,4,4};
//        int[] A = {6,2,3,5,6,3};
        System.out.println(solution(A));
    }

    public static int solution(int[] a) {
        Arrays.sort(a);
        int index = 1;
        int moved = 0;
        for (int i = 0; i < a.length; i++) {
            if (index != a[i]) {
                moved += Math.abs(index - a[i]);
            }
            index++;
        }
        return moved;
    }


}
