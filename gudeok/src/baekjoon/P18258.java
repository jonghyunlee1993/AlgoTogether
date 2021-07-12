package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/***
 * 문제번호 : 18258
 * 문제 타이틀 : 큐2
 * 정답비율 : 31.014%
 * 문제 링크 : https://www.acmicpc.net/problem/18258
 * 참고 : 큐/덱
 */
public class P18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < commandCount; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            String command = input.nextToken();
            switch (command) {
                case "push":
                    queue.add(Integer.parseInt(input.nextToken()));
                    break;
                case "pop" :
                    if(!queue.isEmpty()) {
                        answer.append(queue.poll()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                case "size" :
                    answer.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if(!queue.isEmpty()) {
                        answer.append(0).append("\n");
                    } else {
                        answer.append(1).append("\n");
                    }
                    break;
                case "front" :
                    if(!queue.isEmpty()) {
                        answer.append(queue.peekFirst()).append("\n");
                    } else {
                        answer.append(-1).append("\n");
                    }
                    break;
                case "back" :
                    if(!queue.isEmpty()) {
                        answer.append(queue.peekLast()).append("\n");
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
