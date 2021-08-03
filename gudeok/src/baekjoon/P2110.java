package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 2110
 * 문제 타이틀 : 공유기 설치
 * 정답비율 : 40.643%
 * 문제 링크 : https://www.acmicpc.net/problem/2110
 * 참고 : 이분탐
 */
public class P2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int houseCount = Integer.parseInt(st.nextToken());
        int routerCount = Integer.parseInt(st.nextToken());
        int[] houses = new int[houseCount];
        for (int i = 0; i < houseCount; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int answer = 0;

        int left = 1;
        int right = houses[houseCount - 1] - houses[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int start = houses[0];
            int setRouterCount = 1;
            for (int i = 0; i < houseCount; i++) {
                int distance = houses[i] - start;
                if (distance >= mid) {
                    setRouterCount++;
                    start = houses[i];
                }
            }

            if (setRouterCount >= routerCount) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
