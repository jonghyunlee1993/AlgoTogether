package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {

    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];
        dfs(N,M,0);

        System.out.println(answer);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for (int val : arr) {
                answer.append(val).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N,M,depth + 1);
                visited[i] = false;
            }
        }
    }
}
