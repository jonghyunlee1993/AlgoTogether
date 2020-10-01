package solution;

import java.io.*;
import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/9613
 */
public class SumOfGcd {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while(count-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int answer = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    answer += gcd(a[i],a[j]);
                }
            }
            System.out.println(answer);
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b , a % b);
    }
}
