package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461_3 {

    private static Integer[] dp = new Integer[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 0; i < caseCount; i++) {
            int number = Integer.parseInt(br.readLine());
            int sideLength = getSideLength(number);
            System.out.println(sideLength);
        }
    }

    private static int getSideLength(int number) {
        if(dp[number] == null) {
            dp[number] = getSideLength(number - 2) + getSideLength(number - 3);
        }

        return dp[number];
    }
}
