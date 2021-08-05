package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/***
 * 문제번호 : 1927
 * 문제 타이틀 : 최소 힙
 * 정답비율 : 48.319%
 * 문제 링크 : https://www.acmicpc.net/problem/1927
 * 참고 : 우선순위 큐
 */
public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caculateCount = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < caculateCount; i++) {
            int number = Integer.parseInt(br.readLine());

            if(number == 0) {
                if(queue.isEmpty()) {
                    answer.append(0).append("\n");
                } else {
                    answer.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(number);
            }
        }
        System.out.println(answer);
    }
}
