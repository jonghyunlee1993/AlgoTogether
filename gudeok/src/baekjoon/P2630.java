package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 2630
 * 문제 타이틀 : 색종이 만들기
 * 정답비율 : 70.717%
 * 문제 링크 : https://www.acmicpc.net/problem/2630
 * 참고 : 분할 정복
 */
public class P2630 {
    private static int whitePaper = 0;
    private static int bluePaper = 0;
    private static int[][] colorPaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sideLength = Integer.parseInt(br.readLine());
        colorPaper = new int[sideLength][sideLength];
        StringTokenizer st;
        for (int i = 0; i < sideLength; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sideLength; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkPaper(0, 0, sideLength);
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    private static void checkPaper(int row, int col, int sideLength) {
        if(colorCheck(row, col, sideLength)) {
            if(colorPaper[row][col] == 0) {
                whitePaper++;
            }
            else {
                bluePaper++;
            }
            return;
        }

        int newSize = sideLength / 2;	// 절반 사이즈
        checkPaper(row, col, newSize);						// 2사분면
        checkPaper(row, col + newSize, newSize);				// 1사분면
        checkPaper(row + newSize, col, newSize);				// 3사분면
        checkPaper(row + newSize, col + newSize, newSize);

    }

    private static boolean colorCheck(int row, int col, int sideLength) {
        int color = colorPaper[row][col];

        for (int i = row; i < row + sideLength; i++) {
            for (int j = col; j < col + sideLength; j++) {
                if (colorPaper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
