package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11047
 * 문제 타이틀 : 동전 0
 * 정답비율 : 52.488%
 * 문제 링크 : https://www.acmicpc.net/problem/11047
 * 참고 : 그리디 알고리즘
 */
public class P11047 {

    static int[] coinType;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        coinType = new int[coinCount];

        int answer = 0;

        for (int i = 0; i < coinCount; i++) {
            coinType[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coinType.length; i > 0; i--) {
            answer += (money / coinType[i - 1]);
            if((money / coinType[i - 1]) != 0) {
                money -= coinType[i-1] * (money / coinType[i - 1]);
            }
        }

        System.out.println("==========");
        System.out.println(answer);

    }
}
