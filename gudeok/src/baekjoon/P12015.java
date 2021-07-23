package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 12015
 * 문제 타이틀 : 가장 긴 증가하는 부분 수열 2
 * 정답비율 : 44.087%
 * 문제 링크 : https://www.acmicpc.net/problem/12015
 * 참고 : 이분 탐색
 */

public class P12015 {
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sequenceSize = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[sequenceSize];
        for (int i = 0; i < sequenceSize; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        sequence = new int[sequenceSize + 1];

        int length = 0;
        int index = 0;
        for (int i = 0; i < sequenceSize; i++) {
            if (numbers[i] > sequence[length]) {
                length++;
//                System.out.println("길이 : " + length + " -> " + numbers[i]);
                sequence[length] = numbers[i];
            } else {
                index = binarySearch(0, length, numbers[i]);
//                System.out.println(numbers[i] + " -> " + index);
                sequence[index] = numbers[i];
            }
        }

        System.out.println(length);
    }

    private static int binarySearch(int left, int right, int number) {
        int mid =0;

        while (left < right) {
            mid = (left + right) / 2;
            if (sequence[mid] < number) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
