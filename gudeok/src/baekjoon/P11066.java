package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11066
 * 문제 타이틀 : 파일 합치기
 * 정답비율 : 51.334%
 * 문제 링크 : https://www.acmicpc.net/problem/11066
 * 참고 : 동적 계획법 ( DP )
 */
public class P11066 {

    static int[][] dp;
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            int pageCount = Integer.parseInt(br.readLine());
            int[] pageFileSize = new int[pageCount + 1];
            int[] sum = new int[pageCount + 1];
            dp = new int[pageCount + 1][pageCount + 1];
            sum[0] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j < pageCount + 1; j++) {
                pageFileSize[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + pageFileSize[j];
                for (int k = 1; k < pageCount + 1; k++) {
                    dp[j][k] = MAX;
                }
            }

            System.out.println(getMinimumCost(dp,pageFileSize,sum,1,pageCount));
        }

    }

    private static int getMinimumCost(int[][] dp, int[] pageFileSize, int[] sum, int start, int end) {

        if (start >= end) {
            return 0;
        }
        if (end == start + 1) {
            return pageFileSize[start] + pageFileSize[end];
        }
        for (int i = start; i < end; i++) {
            int temp = getMinimumCost(dp, pageFileSize, sum, start, i) + getMinimumCost(dp, pageFileSize, sum, i + 1, end) + sum[end] - sum[start - 1];
            dp[start][end] = Math.min(dp[start][end], temp);
        }

//        System.out.println("==========");
//        System.out.println(start);
//        System.out.println(end);
//        System.out.println(dp[start][end]);
//        System.out.println("==========");
        return dp[start][end];
    }

}
