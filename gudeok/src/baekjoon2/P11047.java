package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int coinCount = Integer.parseInt(st.nextToken());
        int totalMoney = Integer.parseInt(st.nextToken());
        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = coinCount - 1; i >= 0; i--) {
            int coinsCount = totalMoney / coins[i];
            if(coinsCount != 0) {
                totalMoney -= coins[i] * coinsCount;
                answer += coinsCount;
            }
            if(totalMoney == 0)
                break;
        }
        System.out.println(answer);
    }
}
