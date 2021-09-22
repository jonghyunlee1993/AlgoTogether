package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {

    private static int N;
    private static int[] map;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        dfs(0);
        System.out.println(answer);

    }

    private static void dfs(int depth) {
        if(depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[depth] = i;
            if(possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if(map[col] == map[i]) {
                return false;
            }

            if(Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }

        return true;
    }
}
