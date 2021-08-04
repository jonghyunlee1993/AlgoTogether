package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/***
 * 문제번호 : 11279
 * 문제 타이틀 : 최대 힙
 * 정답비율 : 44.954%
 * 문제 링크 : https://www.acmicpc.net/problem/11279
 * 참고 : 우선순위 큐
 */
public class P11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder answer = new StringBuilder();

        int calculateCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < calculateCount; i++) {
            int calculateNumber = Integer.parseInt(br.readLine());
            if (calculateNumber == 0) {
                int printNumber = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
                answer.append(printNumber).append("\n");
            } else {
                priorityQueue.add(calculateNumber);
            }
        }

        System.out.println(answer);
    }
}
