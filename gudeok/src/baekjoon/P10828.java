package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/***
 * 문제번호 : 10828
 * 문제 타이틀 : 스택
 * 정답비율 : 38.504%
 * 문제 링크 : https://www.acmicpc.net/problem/10828
 * 참고 : 스택
 */
public class P10828 {
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < commandCount; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            String commandKind = command.nextToken();

            switch (commandKind) {
                case "push" :
                    stack.push(Integer.parseInt(command.nextToken()));
                    break;
                case "pop" :
                    if(stack.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(stack.pop()).append("\n");
                    }
                    break;
                case "size" :
                    answer.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    if(stack.isEmpty()) {
                        answer.append(1).append("\n");
                    } else {
                        answer.append(0).append("\n");
                    }
                    break;
                case "top" :
                    if(stack.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(stack.peek()).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(answer);
    }
}
