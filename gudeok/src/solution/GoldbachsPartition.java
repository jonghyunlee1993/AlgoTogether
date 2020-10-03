package solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제링크 : https://www.acmicpc.net/problem/17103
 */
public class GoldbachsPartition {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[1000001];
        for(int i = 2; i <= 1000000; i++) {
            if(check[i] == false) {
                primes.add(i);
                for(int j = i+i; j<=1000000; j+=i) {
                    check[j] = true;
                }
            }
        }

        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int answer = 0;
            for(int p : primes) {
                if(n-p >= 2 && p <= n-p) {
                    if(check[n-p] == false) {
                        answer += 1;
                    }
                } else {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
