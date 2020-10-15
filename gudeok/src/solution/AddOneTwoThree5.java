package solution;

import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/15990
 */
public class AddOneTwoThree5 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        final int limit = 100000;
        final long mod = 1000000009L;

        long[][] dynamic = new long[limit+1][4];
        for(int i = 1; i <= limit; i++) {
            if(i-1 >= 0) dynamic[i][1] = dynamic[i-1][2] + dynamic[i-1][3];
                if(i == 1) dynamic[i][1] = 1;

            if(i-2 >= 0) dynamic[i][2] = dynamic[i-2][1] + dynamic[i-2][3];
                if(i == 2) dynamic[i][2] = 1;

            if(i-3 >= 0) dynamic[i][3] = dynamic[i-3][1] + dynamic[i-3][2];
                if(i == 3) dynamic[i][3] = 1;

            dynamic[i][1] %= mod;
            dynamic[i][2] %= mod;
            dynamic[i][3] %= mod;
        }

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        while (count-- > 0) {
            int number = sc.nextInt();
            System.out.println((dynamic[number][1] + dynamic[number][2] + dynamic[number][3]) % mod);
        }

    }
}
