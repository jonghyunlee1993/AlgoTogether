package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/***
 * 문제번호 : 17298
 * 문제 타이틀 : 오큰수
 * 정답비율 : 34.091%
 * 문제 링크 : https://www.acmicpc.net/problem/17298
 * 참고 : 스택
 */
public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int sequenceSize = Integer.parseInt(br.readLine());
        int[] sequence = new int[sequenceSize];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < sequenceSize; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < sequenceSize; i++) {
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i]) {
                sequence[stack.pop()] = sequence[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            sequence[stack.pop()] = -1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            answer.append(sequence[i]).append(" ");
        }
        System.out.println(answer);
    }
}
