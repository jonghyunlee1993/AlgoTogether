package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/***
 * 문제번호 : 2164
 * 문제 타이틀 : 카드2
 * 정답비율 : 54.284%
 * 문제 링크 : https://www.acmicpc.net/problem/2164
 * 참고 : 큐/덱
 */
public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCount = Integer.parseInt(br.readLine());

        Deque<Integer> card = new LinkedList<>();
        for (int i = 1; i < cardCount + 1; i++) {
            card.addLast(i);
        }

        while (card.size() > 1) {
            card.pollFirst();
            card.addLast(card.pollFirst());
        }

        System.out.println(card.poll());
    }
}
