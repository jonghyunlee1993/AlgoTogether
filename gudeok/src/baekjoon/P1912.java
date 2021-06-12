package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1912
 * 문제 타이틀 : 연속합
 * 정답비율 : 30.806%
 * 문제 링크 : https://www.acmicpc.net/problem/1912
 * 참고 : 동적 계획법 ( DP )
 */
public class P1912 {

    static int[] arr;
    static int max;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        recur(N - 1);


        System.out.println(max);
    }

    private static Integer recur(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
            max = Math.max(max, dp[N]);
        }

        return dp[N];
    }
}
