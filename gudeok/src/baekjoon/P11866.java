package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 문제번호 : 11866
 * 문제 타이틀 : 요세푸스 문제0
 * 정답비율 : 57.843%
 * 문제 링크 : https://www.acmicpc.net/problem/11866
 * 참고 : 큐/덱
 */
public class P11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int peopleCount = Integer.parseInt(st.nextToken());
        int killOrder = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < peopleCount + 1; i++) {
            queue.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        while(queue.size() > 1) {
            for (int i = 0; i < killOrder - 1; i++) {
                queue.offer(queue.poll());
            }
            answer.append(queue.poll()).append(", ");
        }

        answer.append(queue.poll()).append(">");
        System.out.println(answer);
    }
}
