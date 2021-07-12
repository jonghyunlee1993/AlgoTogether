package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1021
 * 문제 타이틀 : 회전하는 큐
 * 정답비율 : 53.664%
 * 문제 링크 : https://www.acmicpc.net/problem/1021
 * 참고 : 큐/덱
 */
public class P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int queueSize = Integer.parseInt(st.nextToken());
        int pullOutSize = Integer.parseInt(st.nextToken());

        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= queueSize; i++) {
            numbers.offer(i);
        }

        int[] pullOutNumbers = new int[pullOutSize];
        StringTokenizer numberLocation = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < pullOutSize; i++) {
            pullOutNumbers[i] = Integer.parseInt(numberLocation.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < pullOutSize; i++) {
            int targetNumber = numbers.indexOf(pullOutNumbers[i]);
            int halfIndex;

            if(numbers.size() % 2 == 0) {
                halfIndex = numbers.size() / 2 - 1;
            } else {
                halfIndex = numbers.size() / 2;
            }

            if(targetNumber <= halfIndex) {
                for(int j = 0; j < targetNumber; j++) {
                    int temp = numbers.pollFirst();
                    numbers.offerLast(temp);
                    answer++;
                }
            } else {
                for(int j = 0; j < numbers.size() - targetNumber; j++) {
                    int temp = numbers.pollLast();
                    numbers.offerFirst(temp);
                    answer++;
                }
            }

            numbers.pollFirst();
        }

        System.out.println(answer);
    }
}
