package programmers.high_score;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(answers);
        System.out.println(solution(answers));
    }

    public static int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) {
                    hit[i]++;
                }
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++) {
            if(max == hit[i]) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list) {
            answer[cnt++] = num;
        }

        return answer;
    }
}
