package solution;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a,b));
    }

    public static String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016,a,b);
        String answer = localDate.getDayOfWeek().toString().substring(1,3);
        return answer;
    }
}
