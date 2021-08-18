package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11049
 * 문제 타이틀 : 행렬 곱셈 순서
 * 정답비율 : 44.107%
 * 문제 링크 : https://www.acmicpc.net/problem/11049
 * 참고 : DP
 */
public class P11049 {

    private static int[][] matrix;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matrixCount = Integer.parseInt(br.readLine());
        matrix = new int[matrixCount][2];
        dp = new int[matrixCount][matrixCount];

        for (int i = 0; i < matrixCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int answer = getMinCost(0,matrixCount-1);
        System.out.println(answer);
    }

    private static int getMinCost(int start, int end) {
        if(start == end) return 0;
        if(dp[start][end] == Integer.MAX_VALUE) {
            for (int i = start; i < end; i++) {
                int cost = getMinCost(start, i) + getMinCost(i+1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1];
                dp[start][end] = Math.min(dp[start][end], cost);
            }
        }

        return dp[start][end];
    }
}
