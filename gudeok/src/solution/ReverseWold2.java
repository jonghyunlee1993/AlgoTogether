package solution;

import java.io.*;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/17413
 */
public class ReverseWold2 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean tag = false;
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch == '<') {
                printStack(bw,stack);
                tag = true;
                bw.write(ch);
            } else if (ch == '>') {
                tag = false;
                bw.write(ch);
            } else if (tag) {
                bw.write(ch);
            } else {
                if (ch == ' ') {
                    printStack(bw,stack);
                    bw.write(ch);
                } else {
                    stack.push(ch);
                }
            }
        }

        printStack(bw, stack);
        bw.write("\n");
        bw.flush();
    }

    public static void printStack(BufferedWriter bw , Stack<Character> stack) throws IOException {
        while(!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
}
