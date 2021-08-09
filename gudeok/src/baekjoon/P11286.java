package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 문제번호 : 11286
 * 문제 타이틀 : 절대값 힙
 * 정답비율 : 56.980%
 * 문제 링크 : https://www.acmicpc.net/problem/11286
 * 참고 : 우선순위 큐
 */
public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int calculateCount = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> array = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) < Math.abs(o2)) {
                    return -1;
                } else if (Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else {
                    if(o1 < o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < calculateCount; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number != 0) {
                array.add(number);
            } else {
                if(array.isEmpty()) {
                    answer.append("0").append("\n");
                } else {
                    answer.append(array.poll()).append("\n");
                }
            }
        }
        System.out.println(answer);
    }
}
