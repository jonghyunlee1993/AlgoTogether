package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 문제번호 : 1874
 * 문제 타이틀 : 스택 수열
 * 정답비율 : 34.311%
 * 문제 링크 : https://www.acmicpc.net/problem/1874
 * 참고 : 스택
 */
public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int numberCount = Integer.parseInt(br.readLine());
        int start = 0;
        while (numberCount-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if(value > start) {
                for (int i = start + 1; i <= value ; i++) {
                    stack.push(i);
                    answer.append("+").append("\n");
                }
                start = value;
            } else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            answer.append("-").append("\n");
        }
        System.out.println(answer);
    }
}
