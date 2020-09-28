package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1978
 */
public class Decimal {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < numberCount; i++) {
            int number = sc.nextInt();

            if(number < 2) continue;

            for(int j = 2; j*j <= number; j++) {
                if(number % j == 0) continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
