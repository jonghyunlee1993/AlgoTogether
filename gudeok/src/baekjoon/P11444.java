package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 문제번호 : 11444
 * 문제 타이틀 : 피보나치 수6
 * 정답비율 : 55.872%
 * 문제 링크 : https://www.acmicpc.net/problem/11444
 * 참고 : 분할 정복
 */
public class P11444 {
    final static long MOD = 1000000007;
    private static long[][] origin = {{1, 1} , {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] A = {{1, 1} , {1, 0}};
        long number = Long.parseLong(br.readLine());

        System.out.println(pow(A, number - 1)[0][0]);
    }

    private static long[][] pow(long[][] A, long fibo) {
        if(fibo == 1 || fibo == 0) {
            return A;
        }

        long[][] ret = pow(A, fibo / 2);

        ret = multiply(ret, ret);

        if(fibo % 2 == 1L) {
            ret = multiply(ret, origin);
        }


        return ret;
    }

    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        return ret;
    }
}
