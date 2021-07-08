package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 문제번호 : 4949
 * 문제 타이틀 : 균형잡힌 세상
 * 정답비율 : 32.800%
 * 문제 링크 : https://www.acmicpc.net/problem/4949
 * 참고 : 스택
 */
public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String string = br.readLine();
            if(string.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(i) == '(' || string.charAt(i) == '[') {
                    stack.push(string.charAt(i));
                } else if (string.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push('x');
                        break;
                    }
                } else if (string.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push('x');
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer.append("yes").append("\n");
            } else {
                answer.append("no").append("\n");
            }
        }

        System.out.println(answer);
    }
}
