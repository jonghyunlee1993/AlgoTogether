package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1654
 * 문제 타이틀 : 랜선 자르기
 * 정답비율 : 20.534%
 * 문제 링크 : https://www.acmicpc.net/problem/1654
 * 참고 : 이분 탐색
 */
public class P1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int currentLanLineCount = Integer.parseInt(st.nextToken());
        int makeLanLineCount = Integer.parseInt(st.nextToken());

        int[] lanLineLength = new int[currentLanLineCount];
        for (int i = 0; i < currentLanLineCount; i++) {
            lanLineLength[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lanLineLength);

        long max = lanLineLength[currentLanLineCount - 1];
        long min = 1;
        long middle = 0;

        while (max >= min) {
            middle = (max + min) / 2;

            long count = 0;
            for (int i = 0; i < lanLineLength.length; i++) {
                count += lanLineLength[i] / middle;
            }

            if (count >= makeLanLineCount) {
                min = middle + 1;
            } else if (count < makeLanLineCount) {
                max = middle - 1;
            }
        }

        System.out.println(max);
    }
}
