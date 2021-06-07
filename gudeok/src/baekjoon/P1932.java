package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1932
 * 문제 타이틀 : 정수 삼각형
 * 정답비율 : 59.572%
 * 문제 링크 : https://www.acmicpc.net/problem/1932
 * 참고 : 동적 계획법 ( DP )
 */
public class P1932 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] t = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
