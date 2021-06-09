package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 1149
 * 문제 타이틀 : RGB거리
 * 정답비율 : 48.300%
 * 문제 링크 : https://www.acmicpc.net/problem/1149
 * 참고 : 동적 계획법 ( DP )
 */
public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] costNumber = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(costNumber[0]);
            cost[i][1] = Integer.parseInt(costNumber[1]);
            cost[i][2] = Integer.parseInt(costNumber[2]);
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i-1][1] , cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0] , cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][0] , cost[i-1][1]);
        }

        System.out.println("**********");
        System.out.println(Math.min(cost[N-1][0] , Math.min(cost[N-1][1] , cost[N-1][2])));
        System.out.println("**********");



    }
}
