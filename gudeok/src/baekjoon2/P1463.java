package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        dp = new Integer[number + 1];
        dp[0] = 0;
        dp[1] = 0;

//        int answer = getMinCalculate(number);
        int answer = getMinCalculate2(number, 0);
        System.out.println(answer);
    }

    private static int getMinCalculate(int number) {
        if (dp[number] == null) {
            if (number % 6 == 0) {
                dp[number] = Math.min(getMinCalculate(number - 1),
                    Math.min(getMinCalculate(number / 3), getMinCalculate(number / 2))) + 1;
            } else if (number % 3 == 0) {
                dp[number] = Math.min(getMinCalculate(number / 3), getMinCalculate(number - 1)) + 1;
            } else if (number % 3 == 0) {
                dp[number] = Math.min(getMinCalculate(number / 2), getMinCalculate(number - 1)) + 1;
            } else {
                dp[number] = getMinCalculate(number - 1) + 1;
            }
        }
        return dp[number];
    }

    private static int getMinCalculate2(int number, int count) {
        if (number < 2) {
            return count;
        }

        return Math.min(getMinCalculate2(number / 2, count + 1 + (number % 2)),
            getMinCalculate2(number / 3, count + 1 + (number % 3)));
    }
}
