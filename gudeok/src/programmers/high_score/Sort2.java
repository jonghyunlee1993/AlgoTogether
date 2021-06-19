package programmers.high_score;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 문제 타이틀: 가장 큰 수
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Sort2 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        solution(numbers2);
    }

    public static void solution(int[] numbers) {
        String test = Arrays.stream(numbers).mapToObj(String::valueOf)
                .sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1)))
                .reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2));

        System.out.println(test);
    }
}
