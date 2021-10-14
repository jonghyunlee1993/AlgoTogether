package test.scatterlab;

import java.util.Arrays;
import java.util.Collections;

public class first {

    public static void main(String[] args) {
        int[][] data = {{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14},
            {2, 0, 12}};
        solution(data);
    }

    public static int[] solution(int[][] data) {
        int[] answer = new int[2];
        int[][] score = new int[7][2];
        int[][] badDays = new int[7][2];

        for (int i = 0; i < data.length; i++) {
            int temperatureScore = 20 - Math.abs(22 - data[i][2]);
            int weatherScore = getWeatherScore(data[i][0], data[i][1]);
            score[i][0] = i;
            score[i][1] = temperatureScore + weatherScore;

            if (data[i][0] == 4 || data[i][1] == 1 || data[i][2] >= 30 || data[i][2] <= 0) {
                badDays[i][0] = i;
                badDays[i][1] = score[i][1];
            }
        }

        int goodDay = getGoodDay(score);
        int badDay = getBadDay(badDays);
        answer[0] = goodDay;
        answer[1] = badDay;
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    private static int getBadDay(int[][] badDays) {
        int minScore = Integer.MAX_VALUE;
        int badDay = 0;

        for (int i = 0; i < badDays.length; i++) {
            if (badDays[i][1] < minScore && badDays[i][1] != 0) {
                minScore = badDays[i][1];
                badDay = badDays[i][0];
            }
        }

        if (minScore == Integer.MAX_VALUE) {
            return -1;
        }
        return badDay;
    }

    private static int getPreferDay(Integer[] days, int maxScore, int[][] score) {
        Integer[] gooDays = Arrays.stream(days).filter(a -> score[a][1] != maxScore)
            .toArray(Integer[]::new);
        int[] preferDays = {5, 4, 6, 2, 3, 1, 0};
        for (int i = 0; i < preferDays.length; i++) {
            for (int j = 0; j < gooDays.length; j++) {
                if (preferDays[i] == gooDays[j]) {
                    return gooDays[j];
                }
            }
        }
        return gooDays[0];
    }

    private static int getGoodDay(int[][] score) {
        int maxScore = Integer.MIN_VALUE;
        int goodDay = 0;
        Integer[] sameScoreDays = new Integer[7];
        for (int i = 0; i < score.length; i++) {
            sameScoreDays[i] = -1;
            if (score[i][1] > maxScore) {
                maxScore = score[i][1];
                goodDay = score[i][0];
            }
            if (score[i][1] == maxScore) {
                sameScoreDays[i] = score[i][0];
            }
        }
        Arrays.sort(sameScoreDays, Collections.reverseOrder());
        if (sameScoreDays[0] == maxScore) {
            goodDay = getPreferDay(sameScoreDays, maxScore, score);
        }

        return goodDay;
    }

    private static int getWeatherScore(int weather, int precipitation) {
        int weatherScore = 0;
        if (weather == 1 || weather == 2) {
            weatherScore = 20;
        } else if (weather == 3) {
            weatherScore = 17;
        } else if (weather == 4) {
            weatherScore = 10;
        }

        if (precipitation == 2) {
            weatherScore = 14;
        }

        return weatherScore;
    }
}
