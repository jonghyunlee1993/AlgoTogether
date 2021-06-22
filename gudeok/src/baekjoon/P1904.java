package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 1904
 * 문제 타이틀 : 01타일
 * 정답비율 : 33.568%
 * 문제 링크 : https://www.acmicpc.net/problem/1904
 * 참고 : 동적 계획법 ( DP )
 */
public class P1904 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        dp = new Integer[length + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(getMaxCount(length) % 15746);
    }

    private static int getMaxCount(int length) {
        if (dp[length] == null) {
            dp[length] = getMaxCount(length - 2) + getMaxCount(length - 1);
        }
        return dp[length];
    }
}
