package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {

    private static int N;
    private static int[][] stats;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += stats[i][j];
                    teamStart += stats[j][i];
                }

                if (!visited[i] && !visited[j]) {
                    teamLink += stats[i][j];
                    teamLink += stats[j][i];
                }
            }
        }

        int diff = Math.abs(teamStart - teamLink);
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        answer = Math.min(answer, diff);
    }
}
