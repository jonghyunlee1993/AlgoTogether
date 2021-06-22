package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 2579
 * 문제 타이틀 : 계단 오르기
 * 정답비율 : 35.124%
 * 문제 링크 : https://www.acmicpc.net/problem/2579
 * 참고 : 동적 계획법 ( DP )
 */
public class P2579 {
    static int[] stairScore;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());

        stairScore = new int[stairCount + 1];
        dp = new Integer[stairCount + 1];

        for (int i = 1; i <= stairCount; i++) {
            stairScore[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairScore[0];
        dp[1] = stairScore[1];

        if(stairCount >= 2)
            dp[2] = stairScore[1] + stairScore[2];

        System.out.println(getMaxScore(stairCount));
    }

    private static int getMaxScore(int stairNumber) {
        if(stairNumber == -1) {
            return 0;
        }

        if(dp[stairNumber] == null) {
            dp[stairNumber] = Math.max(getMaxScore(stairNumber-2)
                    ,getMaxScore(stairNumber-3) + stairScore[stairNumber-1])
                    + stairScore[stairNumber];
        }

        return dp[stairNumber];
    }
}
