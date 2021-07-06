package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 문제번호 : 10773
 * 문제 타이틀 : 제로
 * 정답비율 : 67.995%
 * 문제 링크 : https://www.acmicpc.net/problem/10773
 * 참고 : 스택
 */
public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());
        Stack<Integer> numberStack = new Stack<>();

        int answer = 0;

        for (int i = 0; i < numberCount; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number != 0) {
                numberStack.add(number);
            } else {
                numberStack.pop();
            }
        }

        if(numberStack.isEmpty()) {
            answer = 0;
        } else {
            answer = numberStack.stream().reduce(0,Integer::sum);
        }
        System.out.println(answer);
    }
}
