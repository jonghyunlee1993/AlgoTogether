package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1874
 */

public class StackSequence {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int sequenceLength = Integer.parseInt(br.readLine());
        int i = 1;
        int count = 0;
        int currentNumber = Integer.parseInt(br.readLine());
        while (true) {
            if(!stack.isEmpty()) {
                if(stack.peek() == currentNumber) {
                    sb.append("-").append("\n");
                    stack.pop();
                    count++;

                    if(count == sequenceLength)
                        break;

                    currentNumber = Integer.parseInt(br.readLine());
                    continue;
                }
            }

            stack.add(i++);
            sb.append("+").append("\n");
            if(i > sequenceLength+1)
                break;
        }

        if(stack.size() == 0)
            System.out.println(sb);
        else
            System.out.println("NO");
    }

}
