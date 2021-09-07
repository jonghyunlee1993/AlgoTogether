package baekjoon2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int number : numbers) {
                answer.append(number).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
