package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1780
 * 문제 타이틀 : 종이의 개수
 * 정답비율 : 58.972%
 * 문제 링크 : https://www.acmicpc.net/problem/1780
 * 참고 : 분할 정복
 */
public class P1780 {
    
    private static int[][] paper;
    private static int minusOnePaperCount;
    private static int zeroPaperCount;
    private static int onePaperCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperSize = Integer.parseInt(br.readLine());
        paper = new int[paperSize][paperSize];

        StringTokenizer st;
        for (int i = 0; i < paperSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < paperSize; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperCountCheck(0,0,paperSize);
        System.out.println(minusOnePaperCount);
        System.out.println(zeroPaperCount);
        System.out.println(onePaperCount);
    }

    private static void paperCountCheck(int row, int col, int paperSize) {
        if(paperKindCheck(row,col,paperSize)) {
            switch (paper[row][col]) {
                case -1:
                    minusOnePaperCount++;
                    break;
                case 0:
                    zeroPaperCount++;
                    break;
                case 1:
                    onePaperCount++;
                    break;
                default:
                    break;
            }
            return;
        }

        int newSize = paperSize / 3;
        paperCountCheck(row,col,newSize); //1사분면
        paperCountCheck(row,col + newSize,newSize); //2사분면
        paperCountCheck(row,col + newSize * 2,newSize); //3사분면

        paperCountCheck(row + newSize,col,newSize); //4사분면
        paperCountCheck(row + newSize,col + newSize,newSize); //5사분면
        paperCountCheck(row + newSize,col + newSize * 2,newSize); //6사분면

        paperCountCheck(row + newSize * 2,col,newSize); //7사분면
        paperCountCheck(row + newSize * 2,col + newSize,newSize); //8사분면
        paperCountCheck(row + newSize * 2,col + newSize * 2,newSize); //9사분면

    }

    private static boolean paperKindCheck(int row, int col, int paperSize) {
        int paperKind = paper[row][col];

        for (int i = row; i < row + paperSize; i++) {
            for (int j = col; j < col + paperSize; j++) {
                if(paper[i][j] != paperKind){
                    return false;
                }
            }
        }

        return true;
    }
}
