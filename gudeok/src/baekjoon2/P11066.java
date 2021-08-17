package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066 {

    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int tc = 0; tc < testCaseCount; tc++) {
            int novelPageCount = Integer.parseInt(br.readLine());
            int[] files = new int[novelPageCount + 1];
            int[] sum = new int[novelPageCount + 1];
            int[][] dp = new int[novelPageCount + 1][novelPageCount + 1];

            sum[0] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i < novelPageCount + 1; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i];

                for (int j = 1; j < novelPageCount + 1; j++) {
                    dp[i][j] = MAX;
                }
            }

            answer.append(getMinCost(dp, files, sum, 1, novelPageCount)).append("\n");
        }
        System.out.println(answer);
    }

    private static int getMinCost(int[][] dp, int[] files, int[] sum, int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (end == start + 1) {
            return files[start] + files[end];
        }

        for (int i = start; i < end; i++) {
            int temp = getMinCost(dp, files, sum, start, i)
                + getMinCost(dp, files, sum, i + 1, end)
                + sum[end] - sum[start - 1];

            dp[start][end] = Math.min(dp[start][end], temp);
        }
        return dp[start][end];
    }
}
