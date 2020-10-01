package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1676
 */
public class ZeroOfFactorial {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        int answer = 0;
        for(int i = 5; i <= inputNumber; i*=5) {
            answer += inputNumber / i;
        }

        System.out.println(answer);
    }
}
