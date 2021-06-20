package programmers.high_score;

import java.util.Arrays;

/***
 * 문제 타이틀: H-Index
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Sort3 {
    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
//        case 2
        int[] citations = {0,1,2,3,3,3,3,3,3,4,10,20,30,40};


        solution(citations);
    }

    public static void solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = citations.length-1; i > -1; i--){
            System.out.println("citations[i] : " + citations[i] + "   citations.length - i : " + (citations.length - i));
            System.out.println("==========");

            int min = (int)Math.min(citations[i], citations.length - i);
            if(answer < min) answer = min;
        }

        System.out.println(answer);
    }
}
