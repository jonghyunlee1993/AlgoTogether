package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11399
 * 문제 타이틀 : ATM
 * 정답비율 : 66.099%
 * 문제 링크 : https://www.acmicpc.net/problem/11399
 * 참고 : 그리디 알고리즘
 */
public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int peopleCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] spendTime = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            spendTime[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(spendTime);

        int answer = 0;
        int waitingTime = 0;
        for (int i = 0; i < spendTime.length; i++) {
            if(i != 0) {
                waitingTime += spendTime[i - 1];
            }
            answer += waitingTime + spendTime[i];
        }
        System.out.println(answer);
    }
}
