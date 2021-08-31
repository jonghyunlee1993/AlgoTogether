package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 15650
 * 문제 타이틀 : N과M (2)
 * 정답비율 : 74.779%
 * 문제 링크 : https://www.acmicpc.net/problem/15650
 * 참고 : 백 트래킹
 */
public class P15650 {

    private static int[] numbers;
    private static int N, M;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];

        dfs(1, 0);
        System.out.println(answer);
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int number : numbers) {
                answer.append(number).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            numbers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
