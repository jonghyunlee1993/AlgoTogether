package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1904 {

    private static Integer[] dp = new Integer[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tileCount = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(getMax(tileCount));
    }

    private static int getMax(int tileCount) {
        if (dp[tileCount] == null) {
            dp[tileCount] = (getMax(tileCount - 2) + getMax(tileCount - 1)) % 15746;
        }

        return dp[tileCount];
    }
}
