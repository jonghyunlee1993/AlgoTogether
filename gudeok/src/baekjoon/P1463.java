package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 1463
 * 문제 타이틀 : 1로 만들기
 * 정답비율 : 31.755%
 * 문제 링크 : https://www.acmicpc.net/problem/1463
 * 참고 : 동적 계획법 ( DP )
 */
public class P1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        dp = new Integer[X+1];
        dp[0] = dp[1] = 0;
        System.out.println(recur(X));
    }

    private static int recur(int X) {

        if(dp[X] == null) {
            if(X % 6 == 0) {
                dp[X] = Math.min(recur(X-1) , Math.min(recur(X/3) , recur(X/2))) + 1;
            } else if ( X % 3 == 0) {
                dp[X] = Math.min(recur(X/3) , recur(X-1)) + 1;
            } else if ( X % 2 == 0) {
                dp[X] = Math.min(recur(X/2) , recur(X-1)) + 1;
            } else {
                dp[X] = recur(X-1) + 1;
            }
        }

        return dp[X];
    }

}
