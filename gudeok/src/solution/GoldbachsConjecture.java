package solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/6588
 */
public class GoldbachsConjecture {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[1000000+1];
        ArrayList<Integer> prime = new ArrayList<>();
        check[0] = check[1] = true;
        for (int i=2; i*i <= 1000000; i++) {
            if (check[i] == true) {
                continue;
            }
            prime.add(i);
            for (int j=i+i; j<=1000000; j+=i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i=1; i<prime.size(); i++) {
                int p = prime.get(i);
                if (check[n - p] == false) {
                    System.out.println(n + " = " + p + " + " + (n-p));
                    break;
                }
            }
        }
    }
}
