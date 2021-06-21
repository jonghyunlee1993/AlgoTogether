package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 9251
 * 문제 타이틀 : LCS
 * 정답비율 : 40.431%
 * 문제 링크 : https://www.acmicpc.net/problem/9251
 * 참고 : 동적 계획법 ( DP )
 */
public class P9251 {

    static char[] sequence1;
    static char[] sequence2;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sequence1 = br.readLine().toCharArray();
        sequence2 = br.readLine().toCharArray();

        dp = new Integer[sequence1.length][sequence2.length];

        System.out.println(LCS(sequence1.length - 1, sequence2.length - 1));
    }

    private static int LCS(int x, int y) {
        if(x == -1 || y == -1) {
            return 0;
        }

        if(dp[x][y] == null) {
            dp[x][y] = 0;
            if(sequence1[x] == sequence2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x-1,y), LCS(x, y-1));
            }
        }

        return dp[x][y];
    }
}
