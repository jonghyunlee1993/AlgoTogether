package solution;


import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/10799
 */
public class Ironbar {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        String ironBar = sc.nextLine().trim();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < ironBar.length(); i++) {
            char c = ironBar.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.peek()+1 == i) {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}
