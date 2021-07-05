package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1931
 * 문제 타이틀 : 회의실 배정
 * 정답비율 : 28.783%
 * 문제 링크 : https://www.acmicpc.net/problem/1931
 * 참고 : 그리디 알고리즘
 */
public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetCount = Integer.parseInt(br.readLine());
        int[][] meetTime = new int[meetCount][2];

        for (int i = 0; i < meetCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetTime[i][0] = Integer.parseInt(st.nextToken(" "));
            meetTime[i][1] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(meetTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int answer = 0;
        int prevEndTime = 0;
        for (int i = 0; i < meetTime.length; i++) {
            if(prevEndTime <= meetTime[i][0]) {
                prevEndTime = meetTime[i][1];
                answer++;
            }
        }
        System.out.println(answer);

    }
}
