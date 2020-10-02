package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/17087
 */
public class HideAndSeek {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int myPoint = sc.nextInt();
        int[] a = new int[peopleCount];

        for(int i = 0; i < peopleCount; i++) {
            int x = sc.nextInt();
            int diff = Math.abs(myPoint - x);
            a[i] =diff;
        }

        int answer = a[0];
        for(int i = 1; i < peopleCount; i++) {
            answer = gcd(answer, a[i]);
        }
        System.out.println(answer);
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b , a % b);
    }
}
