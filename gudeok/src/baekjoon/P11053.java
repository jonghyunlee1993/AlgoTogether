package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11053
 * 문제 타이틀 : 가장 긴 증가하는 부분 수열
 * 정답비율 : 36.928%
 * 문제 링크 : https://www.acmicpc.net/problem/11053
 * 참고 : 동적 계획법 ( DP )
 */
public class P11053 {

    private static int[] numbers;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("==========");
        System.out.println(test(numbers));
        System.out.println("==========");

        for (int i = 0; i < N; i++) {
            recur(i);
        }

        int max = dp[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int recur(int N) {
        if (dp[N] == null) {
            dp[N] = 1;
            for (int i = N - 1; i >= 0; i--) {
                if (numbers[i] < numbers[N]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }

    private static int test(int[] nums) {
        int max = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                length++;
            }
        }
        return length;
    }
}
