package solution;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/17298
 *
 * 처음에 내가 상상한 풀이 방법
 * - 이중포문을 돌면서 현재 인덱스값 뒤에 애들과 다 비교해주며 큰수가 나오면 바로 그애를 리턴값에 넣어줌.
 *
 * 스택을 이용한 풀이 방법
 * -
 *
 */
public class RightBigNumber {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());
        int[] inputNumbers = new int[n];
        int[] answer = new int[n];

        String[] numbers = bf.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            inputNumbers[i] = Integer.parseInt(numbers[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            System.out.println(stack);
            while(!stack.isEmpty() && inputNumbers[stack.peek()] < inputNumbers[i]) {
                answer[stack.pop()] = inputNumbers[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        for (int i=0; i<n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}
