package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11054
 * 문제 타이틀 : 가장 긴 바이토닉 부분 수열
 * 정답비율 : 51.284%
 * 문제 링크 : https://www.acmicpc.net/problem/11054
 * 참고 : 동적 계획법 ( DP )
 */
public class P11054 {
    private static int[] numbers;
    private static Integer[] r_dp;
    private static Integer[] l_dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        r_dp = new Integer[N];
        l_dp = new Integer[N];
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(r_dp[i] + l_dp[i], max);
        }

        System.out.println("**********");
        System.out.println(max - 1);
        System.out.println("**********");


    }

    private static int LIS(int N) {
        if (r_dp[N] == null) {
            r_dp[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (numbers[i] < numbers[N]) {
                    r_dp[N] = Math.max(r_dp[N], LIS(i) + 1);
                }
            }
        }
        return r_dp[N];
    }

    private static int LDS(int N) {
        if (l_dp[N] == null) {
            l_dp[N] = 1;
            for (int i = N + 1; i < l_dp.length; i++) {
                if (numbers[i] < numbers[N]) {
                    l_dp[N] = Math.max(l_dp[N], LDS(i) + 1);
                }
            }
        }
        return l_dp[N];
    }
}
