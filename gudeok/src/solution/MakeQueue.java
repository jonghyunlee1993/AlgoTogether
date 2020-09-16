package solution;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/10845
 */
public class MakeQueue {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int commandCount = sc.nextInt();
        for(int i = 0; i < commandCount; i++) {
            String cmd = sc.next();
            if(cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue.offer(num);
            } else if(cmd.equals("front")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peek());
                }
            } else if(cmd.equals("size")) {
                System.out.println(queue.size());
            } else if(cmd.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if(cmd.equals("pop")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.poll());
                }
            } else if(cmd.equals("back")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peek());
                }
            }
        }

    }
}
