package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/***
 * 문제번호 : 5430
 * 문제 타이틀 : AC
 * 정답비율 : 20.158%
 * 문제 링크 : https://www.acmicpc.net/problem/5430
 * 참고 : 스택
 */
public class P5430 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int caseCount = Integer.parseInt(br.readLine());
        while(caseCount --> 0) {
            String command = br.readLine();
            int arraySize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            for(int i = 0; i < arraySize; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(command, deque);
        }
        System.out.println(answer);

    }

    private static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for(char cmd : command.toCharArray()) {
            if(cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if(isRight) {
                if (deque.pollFirst() == null) {
                    answer.append("error\n");
                    return;
                }
            } else {
                if(deque.pollLast() == null) {
                    answer.append("error\n");
                    return;
                }
            }
        }
        makeAnswer(deque,isRight);
    }

    private static void makeAnswer(ArrayDeque<Integer> deque, boolean isRight) {
        answer.append("[");
        if(deque.size() > 0) {
            if(isRight) {
                answer.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollFirst());
                }
            } else {
                answer.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollLast());
                }
            }
        }
        answer.append(']').append('\n');
    }
}
