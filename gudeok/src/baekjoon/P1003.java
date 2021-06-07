package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException {

        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            fibonachi(n);
            sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static Integer[] fibonachi(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonachi(n - 1)[0] + fibonachi(n - 2)[0];
            dp[n][1] = fibonachi(n - 1)[1] + fibonachi(n - 2)[1];
        }
        return dp[n];
    }
}
