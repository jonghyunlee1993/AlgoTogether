package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 2740
 * 문제 타이틀 : 행렬 곱셈
 * 정답비율 : 71.020%
 * 문제 링크 : https://www.acmicpc.net/problem/2740
 * 참고 : 분할 정복
 */
public class P2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        // B행렬 입력
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int sum = 0;
                for(int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }
                // A의 i행의 j열 연산이 끝나면 바로 출력문으로 보내준다.
                answer.append(sum).append(' ');
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
}
