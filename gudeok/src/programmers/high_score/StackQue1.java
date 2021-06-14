package programmers.high_score;

import java.util.Arrays;

/***
 * 문제 타이틀: 기능개발
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class StackQue1 {
    public static void main(String[] args) {
        //case 1
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //case 2
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        5 , 10 , 1, 1, 20 ,1

        int[] test = solution(progresses , speeds);

    }

    public static int[] solution(int[] progresses , int[] speeds) {
//        int[] days = new int[progresses.length];
//        for(int i = 0; i < progresses.length; i++) {
//            if((100 - progresses[i]) % speeds[i] != 0) {
//                days[i] =  (100 - progresses[i]) / speeds[i] + 1;
//            } else {
//                days[i] = (100 - progresses[i]) / speeds[i];
//            }
//        }


        // 미친 풀이... 프로그래머스... 미친놈...
        int[] dayOfEnd = new int[100];
        int day = -1;
        for(int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }

        return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
    }
}
