package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/***
 * 문제번호 : 10816
 * 문제 타이틀 : 숫자 카드2
 * 정답비율 : 35.451%
 * 문제 링크 : https://www.acmicpc.net/problem/10816
 * 참고 : 이분 탐색
 */
public class P10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCards = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer,Integer> cards = new HashMap<>();
        for (int i = 0; i < numberOfCards; i++) {
            int number = Integer.parseInt(st.nextToken());
            cards.put(number ,cards.getOrDefault(number,0) + 1);
        }

        int numberOfTargets = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numberOfTargets; i++) {
            int count = cards.getOrDefault(Integer.parseInt(st.nextToken()),0);
            answer.append(count).append(" ");
        }

        System.out.println(answer);
    }
}
