package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/11052
 */
public class BuyCard {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int cardCount = sc.nextInt();
        int[] price = new int[cardCount + 1];

        for(int i = 1; i <= cardCount; i++) {
            price[i] = sc.nextInt();
        }

        int[] dynamic = new int[cardCount + 1];
        for(int i = 1; i <= cardCount; i++) {
            for(int j = 1; j <= i; j++) {
                if(dynamic[i] < dynamic[i-j] + price[j])
                    dynamic[i] = dynamic[i-j] + price[j];
            }
        }

//        System.out.println(dynamic[0]);
        System.out.println(dynamic[cardCount]);

    }
}
