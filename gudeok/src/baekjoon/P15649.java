package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 15649
 * 문제 타이틀 : N과M (1)
 * 정답비율 : 60.413%
 * 문제 링크 : https://www.acmicpc.net/problem/15649
 * 참고 : 백 트래킹
 */
public class P15649 {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        dfs(N,M,0);
        System.out.println(answer);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int value : arr) {
                answer.append(value).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
