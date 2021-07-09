package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/***
 * 문제번호 : 10866
 * 문제 타이틀 : 덱
 * 정답비율 : 56.464%
 * 문제 링크 : https://www.acmicpc.net/problem/10866
 * 참고 : 큐/덱
 */
public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!dq.isEmpty()) {
                        answer.append(dq.pollFirst()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if (!dq.isEmpty()) {
                        answer.append(dq.pollLast()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                case "size":
                    answer.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (!dq.isEmpty()) {
                        answer.append(0).append("\n");
                    } else {
                        answer.append(1).append("\n");
                    }
                    break;
                case "front":
                    if(!dq.isEmpty()) {
                        answer.append(dq.peekFirst()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(!dq.isEmpty()) {
                        answer.append(dq.peekLast()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(answer);
    }
}
