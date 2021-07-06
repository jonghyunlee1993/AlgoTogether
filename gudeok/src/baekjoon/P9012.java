package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 문제번호 : 9012
 * 문제 타이틀 : 괄호
 * 정답비율 : 42.423%
 * 문제 링크 : https://www.acmicpc.net/problem/9012
 * 참고 : 스택
 */
public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int caseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCount; i++) {
            answer.append(checkVPS(br.readLine())).append("\n");
        }

        System.out.println(answer);
    }

    private static String checkVPS(String parentheses) {
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char parenthesis = parentheses.charAt(i);

            if(parenthesis == '(') {
                parenthesisStack.push(parenthesis);
            } else if (parenthesisStack.isEmpty()) {
                return "NO";
            } else {
                parenthesisStack.pop();
            }
        }

        if(parenthesisStack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}