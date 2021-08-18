package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {

    private static Integer[] dp;
    private static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairCount = Integer.parseInt(br.readLine());
        dp = new Integer[stairCount + 1];

        stairs = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = stairs[1];
        if (stairCount >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        int answer = getMaxPoint(stairCount);
        System.out.println(answer);
    }

    private static int getMaxPoint(int stairCount) {
        if (dp[stairCount] == null) {
            dp[stairCount] = Math.max(getMaxPoint(stairCount - 2),
                getMaxPoint(stairCount - 3) + stairs[stairCount - 1])
                + stairs[stairCount];
        }

        return dp[stairCount];
    }
}
