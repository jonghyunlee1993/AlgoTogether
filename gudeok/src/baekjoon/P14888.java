package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 14888
 * 문제 타이틀 : 연산자 끼워넣기
 * 정답비율 : 49.389%
 * 문제 링크 : https://www.acmicpc.net/problem/14888
 * 참고 : 백 트래킹
 */
public class P14888 {

    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    private static int[] numbers;
    private static int[] operators = new int[4];
    private static int numberCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0],1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void dfs(int number, int index) {
        if (index == numberCount) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0 :
                        dfs(number + numbers[index], index + 1);
                        break;
                    case 1 :
                        dfs(number - numbers[index], index + 1);
                        break;
                    case 2 :
                        dfs(number * numbers[index], index + 1);
                        break;
                    case 3 :
                        dfs(number / numbers[index], index + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
