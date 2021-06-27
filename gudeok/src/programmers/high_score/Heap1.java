package programmers.high_score;

import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * 문제 타이틀: 더 맵게
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Heap1 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        solution(scoville,K);
    }

    public static void solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int weakHot = pq.poll();
            int secondWeakHot = pq.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            pq.add(mixHot);
            answer++;
        }

        if(pq.size() <= 1 && pq.peek() < K)
            answer = -1;

        System.out.println(answer);
    }
}
