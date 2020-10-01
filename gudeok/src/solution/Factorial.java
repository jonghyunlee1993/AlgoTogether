package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/10872
 */
public class Factorial {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        int answer = 1;
        for(int i = 1; i <= inputNumber; i++){
            answer *= i;
        }
        System.out.println(answer);
    }
}
