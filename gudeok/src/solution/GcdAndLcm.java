package solution;

import java.util.Scanner;

/**
 * 문제링크 : https://www.acmicpc.net/problem/2609
 */
public class GcdAndLcm {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a,b);
        int lcm = a * b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);

    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b , a % b);
    }
}
