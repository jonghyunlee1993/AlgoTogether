package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 문제번호 : 1992
 * 문제 타이틀 : 쿼드트리
 * 정답비율 : 59.585%
 * 문제 링크 : https://www.acmicpc.net/problem/1992
 * 참고 : 분할 정복
 */
public class P1992 {
    private static StringBuilder answer = new StringBuilder();
    private static int[][] video;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int videoSize = Integer.parseInt(br.readLine());

        video = new int[videoSize][videoSize];
        for (int i = 0; i < videoSize; i++) {
            int[] test = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < videoSize; j++) {
                video[i][j] = test[j];
            }
        }
        compact(0,0,videoSize);

        System.out.println(answer);
    }

    private static void compact(int row, int col, int videoSize) {
        if(colorCheck(row,col,videoSize)) {
            answer.append(video[row][col]);
            return;
        }

        int newSize = videoSize / 2;
        answer.append("(");
        compact(row, col, newSize); // 왼쪽 상단
        compact(row, col + newSize, newSize); // 오른쪽 상단
        compact(row + newSize, col, newSize); // 왼쪽 하단
        compact(row + newSize, col + newSize, newSize); // 오른쪽 하단
        answer.append(")");
    }

    private static boolean colorCheck(int row, int col, int videoSize) {
        int color = video[row][col];
        for (int i = row; i < row + videoSize; i++) {
            for (int j = col; j < col + videoSize; j++) {
                if(video[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
