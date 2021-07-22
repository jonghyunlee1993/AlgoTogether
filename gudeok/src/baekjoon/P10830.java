package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 10830
 * 문제 타이틀 : 행렬 제곱
 * 정답비율 : 34.287%
 * 문제 링크 : https://www.acmicpc.net/problem/10830
 * 참고 : 분할 정복
 */
public class P10830 {

    final static int MOD = 1000;
    private static int processionSize;
    private static int[][] procession;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        processionSize = Integer.parseInt(st.nextToken());
        long exponent = Long.parseLong(st.nextToken());

        procession = new int[processionSize][processionSize];

        for(int i = 0; i < processionSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < processionSize; j++) {
                procession[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(procession, exponent);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < processionSize; i++) {
            for(int j = 0; j < processionSize; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    private static int[][] pow(int[][] procession, long exponent) {
        if(exponent == 1L) {
            return procession;
        }

        int[][] powProcession = pow(procession, exponent / 2);

        powProcession = multiply(powProcession,powProcession);

        if(exponent % 2 == 1L) {
            powProcession = multiply(powProcession, procession);
        }

        return powProcession;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] multiplyProcession = new int[processionSize][processionSize];
        for(int i = 0; i < processionSize; i++) {
            for(int j = 0; j < processionSize; j++) {
                for(int k = 0; k < processionSize; k++) {
                    multiplyProcession[i][j] += o1[i][k] * o2[k][j];
                    multiplyProcession[i][j] %= MOD;
                }
            }
        }

        return multiplyProcession;
    }
}
