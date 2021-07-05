package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 문제번호 : 13305
 * 문제 타이틀 : 주유소
 * 정답비율 : 36.304%
 * 문제 링크 : https://www.acmicpc.net/problem/13305
 * 참고 : 그리디 알고리즘
 */
public class P13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long cityCount = Integer.parseInt(br.readLine());
        long[] distance = Arrays.stream(br.readLine().split(" "))
            .mapToLong(dist -> Integer.parseInt(dist)).toArray();
        long[] oilPrice = Arrays.stream(br.readLine().split(" "))
            .mapToLong(price -> Integer.parseInt(price)).toArray();
        long[] minOilPrice = new long[oilPrice.length];

        long minPrice = oilPrice[0];
        for (int i = 0; i < oilPrice.length; i++) {
            minPrice = oilPrice[i] < minPrice ? oilPrice[i] : minPrice;
            minOilPrice[i] = minPrice;
        }

        long answer = 0;
        for (int i = 0; i < distance.length; i++) {
            answer += distance[i] * minOilPrice[i];
        }
        System.out.println(answer);
    }
}
