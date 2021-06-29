package programmers.high_score;

/***
 * 문제 타이틀: 체육복
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Greedy1 {

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,3,4};
        int[] reserve = {3,4,5};
        solution(n, lost, reserve);
    }

    public static void solution(int n, int[] lost, int[] reserve) {
        int people[] = new int[n];
        int answer = n;

        for (int l : lost) {
            people[l - 1]--;
        }
        for (int r : reserve) {
            people[r - 1]++;
        }

        for (int i = 0; i < people.length; i++) {
            if (people[i] == -1) {
                if (i - 1 >= 0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                } else if(i + 1 < people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                } else {
                    answer--;
                }
            }
        }

        System.out.println(answer);
    }

}
