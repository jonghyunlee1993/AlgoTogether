package solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int peopleCount = sc.nextInt();
        int orderNumber = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= peopleCount; i++) {
            queue.offer(i);
        }

        for(int i =0; i < peopleCount-1; i++) {
            for(int j = 0; j < orderNumber-1; j++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }
}
