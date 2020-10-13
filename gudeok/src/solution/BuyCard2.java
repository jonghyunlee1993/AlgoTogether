package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/16194
 */
public class BuyCard2 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int buyCount = sc.nextInt();
        int[] price = new int[buyCount + 1];
        for(int i = 1; i <= buyCount; i++) {
            price[i] = sc.nextInt();
        }

        int[] dynamic = new int[buyCount + 1];

        for(int i = 1; i <= buyCount; i++) {
            dynamic[i] = -1;
            for(int j = 1; j <= i; j++) {
                if(dynamic[i] == -1 || dynamic[i] > dynamic[i - j] + price[j])
                    dynamic[i] = dynamic[i - j] + price[j];
            }
        }

        System.out.println(dynamic[buyCount]);
    }
}
