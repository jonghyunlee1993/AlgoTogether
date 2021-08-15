package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {

    private static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int i = 0; i < testCount; i++) {
            int testCase = Integer.parseInt(br.readLine());
            answer.append(getSideLength(testCase)).append("\n");
        }

        System.out.println(answer);

    }

    private static long getSideLength(int testCase) {
        if(dp[testCase] == null) {
            dp[testCase] = getSideLength(testCase - 2) + getSideLength(testCase - 3);
        }
        return dp[testCase];
    }
}
