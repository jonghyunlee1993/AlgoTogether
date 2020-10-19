package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/10844
 */
public class EasyStairCount {
    public static long mod = 100000000L;

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][10];

        for(int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                d[i][j] = 0;
                if(j - 1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                if(j + 1 <= 9) {
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }

        long answer = 0;
        for(int i = 0; i <= 9; i++) {
            answer += d[n][i];
        }
        answer %= mod;
        System.out.println(answer);
    }
}
