package programmers.high_score;

import java.util.Collections;
import java.util.PriorityQueue;

/***
 * 문제 타이틀: 이중 우선순위 큐
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Heap3 {
    public static void main(String[] args) {
//        String[] operations = {"I 16","D 1"};
        String[] operations = {"I 7","I 5","I -5","D -1"};
        solution(operations);
    }

    public static void solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String operation[] = operations[i].split(" ");
            switch (operation[0]) {
                case "I" :
                    q.add(Integer.parseInt(operation[1]));
                    reverseQ.add(Integer.parseInt(operation[1]));
                    break;
                case "D" :
                    if(q.size() > 0) {
                        if(Integer.parseInt(operation[1]) == 1) {
                            int max = reverseQ.poll();
                            q.remove(max);
                        } else {
                            int min = q.poll();
                            reverseQ.remove(min);
                        }
                    }
                    break;
            }
        }

        if(q.size() >= 2) {
            answer[0] = reverseQ.poll();
            answer[1] = q.poll();
        }

        System.out.println("==========");
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println("==========");

    }
}
