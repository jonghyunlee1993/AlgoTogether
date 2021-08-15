package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 문제번호 : 1655
 * 문제 타이틀 : 가운데를 말해요
 * 정답비율 : 31.554%
 * 문제 링크 : https://www.acmicpc.net/problem/1655
 * 참고 : 우선순위 큐
 */
public class P1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < numberCount; i++) {
            int number = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }

            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int tmp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(tmp);
            }

            answer.append(maxHeap.peek()).append("\n");
        }

        System.out.println(answer);
    }
}
