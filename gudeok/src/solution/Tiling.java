package solution;

import java.util.Scanner;

/**
 * 문제링크 : https://www.acmicpc.net/problem/11726
 */
public class Tiling {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int d[] = new int[1001];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= number; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.println(d[number]);
    }
}
