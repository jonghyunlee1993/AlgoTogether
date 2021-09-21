package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {

    private static int N;
    private static int M;
    private static StringBuilder answer = new StringBuilder();
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int number : numbers) {
                answer.append(number).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[depth] = i + 1;
            dfs(depth + 1);
        }


    }
}
