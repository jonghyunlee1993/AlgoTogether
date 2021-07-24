package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1920
 * 문제 타이틀 : 수 찾기
 * 정답비율 : 30.658%
 * 문제 링크 : https://www.acmicpc.net/problem/1920
 * 참고 : 이분 탐색
 */
public class P1920 {

    static int[] originNumbers;
    static int[] targetNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int originNumberCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        originNumbers = new int[originNumberCount];
        for (int j = 0; j < originNumberCount; j++) {
            originNumbers[j] = Integer.parseInt(st.nextToken());
        }

        int targetNumberCount = Integer.parseInt(br.readLine());
        targetNumbers = new int[targetNumberCount];
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < targetNumberCount; j++) {
            targetNumbers[j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        Arrays.sort(originNumbers);

        for (int i = 0; i < targetNumbers.length; i++) {
            answer.append(findNumber(originNumbers, targetNumbers[i])).append("\n");
        }

        System.out.println(answer);
    }

    private static int findNumber(int[] numbers, int targetNumber) {
        int low = 0;
        int high = numbers.length -1;
        int mid = 0;

        while(low <= high) {
            mid = (low + high) / 2;
            if(numbers[mid] == targetNumber) {
                return 1;
            } else if (numbers[mid] > targetNumber) {
                high = mid - 1;
            } else if (numbers[mid] < targetNumber) {
                low = mid + 1;
            }
        }
        return 0;
    }
}
