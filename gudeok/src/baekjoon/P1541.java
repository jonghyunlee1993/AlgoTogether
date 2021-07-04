package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1541
 * 문제 타이틀 : 잃어버린 괄호
 * 정답비율 : 31.755%
 * 문제 링크 : https://www.acmicpc.net/problem/1541
 * 참고 : 그리디 알고리즘
 */
public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        int answer = Integer.MAX_VALUE;
        while (subtraction.hasMoreTokens()) {
            String expression = subtraction.nextToken();
            int sum = 0;
            if (expression.contains("+")) {
                sum = Arrays.stream(expression.split("\\+")).mapToInt(a -> Integer.parseInt(a))
                    .sum();
            } else {
                sum = Integer.parseInt(expression);
            }

            answer = answer == Integer.MAX_VALUE ? sum : answer - sum;
        }
        System.out.println(answer);
    }
}
