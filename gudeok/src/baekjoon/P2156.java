package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 2156
 * 문제 타이틀 : 포도주 시식
 * 정답비율 : 33.238%
 * 문제 링크 : https://www.acmicpc.net/problem/2156
 * 참고 : 동적 계획법 ( DP )
 */
public class P2156 {

    static Integer[] maxAmount;
    static int[] wineAmount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wineCount = Integer.parseInt(br.readLine());
        maxAmount = new Integer[wineCount + 1];
        wineAmount = new int[wineCount + 1];
        for (int i = 1; i < wineCount + 1; i++) {
            wineAmount[i] = Integer.parseInt(br.readLine());
        }

        maxAmount[0] = 0;
        maxAmount[1] = wineAmount[1];

        if(wineCount > 1) {
            maxAmount[2] = wineAmount[1] + wineAmount[2];
        }

        getMaxAmount(wineCount);
        System.out.println(maxAmount[wineCount]);
    }

    private static int getMaxAmount(int wineOrder) {

        if (maxAmount[wineOrder] == null) {
            maxAmount[wineOrder] = Math.max(
                    Math.max(getMaxAmount(wineOrder - 2)
                    , getMaxAmount(wineOrder - 3) + wineAmount[wineOrder - 1]) + wineAmount[wineOrder]
                    , getMaxAmount(wineOrder - 1));
        }
        return maxAmount[wineOrder];
    }
}
