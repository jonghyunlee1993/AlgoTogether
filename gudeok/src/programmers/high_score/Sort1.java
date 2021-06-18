package programmers.high_score;

import java.util.Arrays;

/***
 * 문제 타이틀: K번째 수
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tempArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tempArray);
            answer[i] = tempArray[commands[i][2] - 1];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("==========");
            System.out.println(answer[i]);
            System.out.println("==========");

        }

        return answer;
    }
}
