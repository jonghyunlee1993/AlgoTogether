package solution;

import java.io.*;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/9093
 */

public class ReverseWord {
    public static void main(String[] args) throws IOException {
        String input = "i am happy today";
        System.out.println(solution(input));
        reverseWord2();
    }

    // only input.
    public static String solution(String input) {
        String[] word = input.split("");
        Stack<String> stack = new Stack<>();
        String answer = null;
        for(int i = 0; i < word.length; i++) {
            stack.push(word[i]);
        }

        for(int i = 0; i < word.length; i++) {
            String test = stack.pop();
            answer += test;
        }

        return answer;
    }

    public static void reverseWord2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String str = bf.readLine() + "\n";
            Stack<Character> s = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == '\n' || ch == ' ') {
                    while (!s.isEmpty()) {
                        bw.write(s.pop());
                    }
                    bw.write(ch);
                } else {
                    s.push(ch);
                }
            }
        }
        bw.flush();

    }

}
