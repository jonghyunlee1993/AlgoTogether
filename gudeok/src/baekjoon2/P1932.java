package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1932 {

    private static Integer[][] dp;
    private static int[][] triangle;
    private static int triangleSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        triangleSize = Integer.parseInt(br.readLine());
        dp = new Integer[triangleSize][triangleSize];
        triangle = new int[triangleSize][triangleSize];

        for (int i = 0; i < triangleSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < triangleSize; i++) {
            dp[triangleSize - 1][i] = triangle[triangleSize - 1][i];
        }

        int answer = getMaxSum(0, 0);
        System.out.println(answer);

    }

    private static int getMaxSum(int depth, int index) {

        if (dp[depth][index] == null) {
            dp[depth][index] =
                Math.max(getMaxSum(depth + 1, index), getMaxSum(depth + 1, index + 1))
                    + triangle[depth][index];
        }

        return dp[depth][index];
    }
}
