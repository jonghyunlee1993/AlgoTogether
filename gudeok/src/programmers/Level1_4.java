package programmers;

/***
 * 문제 타이틀: 음양 더하기
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class Level1_4 {
    public static void main(String[] args) {
        // case 1
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        // case 2
//        int[] absolutes = {1,2,3};
//        boolean[] signs = {false,false,true};

        solution(absolutes,signs);
    }

    public static void solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            int sign = signs[i] == true ? 1 : -1;
            answer += absolutes[i] * sign;
        }

        System.out.println(answer);
    }
}
