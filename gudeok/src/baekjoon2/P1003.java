package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {

    private static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < caseCount; i++) {
            int number = Integer.parseInt(br.readLine());
            fibonacci(number);
            answer.append(dp[number][0]).append(" ").append(dp[number][1]).append("\n");
        }
        System.out.println(answer);
    }

    private static Integer[] fibonacci(int number) {
        if (dp[number][0] == null || dp[number][1] == null) {
            dp[number][0] = fibonacci(number - 1)[0] + fibonacci(number - 2)[0];
            dp[number][1] = fibonacci(number - 1)[1] + fibonacci(number - 2)[1];
        }

        return dp[number];
    }
}
