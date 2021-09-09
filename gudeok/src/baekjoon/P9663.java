package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 9663
 * 문제 타이틀 : N-Queen
 * 정답비율 : 51.471%
 * 문제 링크 : https://www.acmicpc.net/problem/9663
 * 참고 : 백트래킹
 */
public class P9663 {

    private static int[] arr;
    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);

    }

    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }

            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
