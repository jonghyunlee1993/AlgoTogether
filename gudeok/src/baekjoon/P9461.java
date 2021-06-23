package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

/***
 * 문제번호 : 9461
 * 문제 타이틀 : 파도반 수열
 * 정답비율 : 40.822%
 * 문제 링크 : https://www.acmicpc.net/problem/9461
 * 참고 : 동적 계획법 ( DP )
 */
public class P9461 {

    static int[] numberLength;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());

        numberLength = new int[caseCount + 1];

        int max = 0;
        for (int i = 1; i <= caseCount; i++) {
            numberLength[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, numberLength[i]);
        }

        dp = new Integer[max + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 1; i < numberLength.length; i++) {
            System.out.println(getLegLength(numberLength[i]));
        }

    }

    private static int getLegLength(int i) {
        if(dp[i] == null) {
            dp[i] = getLegLength(i - 2) + getLegLength(i - 3);
        }
        return dp[i];
    }
}
