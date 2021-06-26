package programmers.high_score;

/***
 * 문제 타이틀: 주식 가격
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StackQue4 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int seconds = 0;
            for (int j = i + 1; j < prices.length; j++) {
                seconds++;
                if(prices[i] > prices[j])
                    break;
            }
            answer[i] = seconds;
        }

        return answer;
    }
}
