package solution;

import java.io.*;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/1406
 */
public class Editor {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String originalWord = bf.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for(int i = 0; i < originalWord.length(); i++) {
            leftStack.push(originalWord.charAt(i));
        }

        int count = Integer.parseInt(bf.readLine());
        while(count-- > 0) {
            String[] line = bf.readLine().split(" ");
            char command = line[0].charAt(0);
            if(command == 'L') {
                if(!leftStack.empty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (command == 'D') {
                if(!rightStack.empty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (command == 'P') {
                leftStack.push(line[1].charAt(0));
            } else if (command == 'B') {
                if(!leftStack.empty()) {
                    leftStack.pop();
                }
            }
        }

        while (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!rightStack.empty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);


    }
}
