package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11401
 * 문제 타이틀 : 이항 계수3
 * 정답비율 : 43.541%
 * 문제 링크 : https://www.acmicpc.net/problem/11401
 * 참고 : 분할 정복
 */
public class P11401 {

    final static long P = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long numer = factorial(N);
        long denom = factorial(K) * factorial(N - K) % P;

        System.out.println(numer * pow(denom, P - 2) % P);

    }

    private static long factorial(long n) {
        long fac = 1L;

        while(n > 1) {
            fac = (fac * n) % P;
            n--;
        }
        return fac;
    }

    private static long pow(long base, long expo) {
        if(expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);
        if(expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }
        return temp * temp % P;
    }
}
