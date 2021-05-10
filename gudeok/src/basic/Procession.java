package basic;

import java.util.Arrays;

public class Procession {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        int[][] answer = solution(arr1,arr2);
        for(int i=0; i< answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2.length];
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j< arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
