package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/9095
 */
public class AddOneTwoThree {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[12];
        d[0] = 1;
        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <=3; j++) {
                if(i - j >= 0) {
                    d[i] += d[i-j];
                }
            }
        }

        while(n-- > 0) {
            int testCase = sc.nextInt();
            System.out.println(d[testCase]);
        }
    }
}
