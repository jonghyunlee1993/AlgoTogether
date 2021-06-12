package programmers;


/***
 * 문제 타이틀: [카카오 인턴] 키패드 누르기
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Level1_2 {

    private static final int[][] KEYPAD = new int[][] {
            {3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}
    };

    public static void main(String[] args) {

        //case 1
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";


        //case 2
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";

        solution(numbers,hand);
    }

    public static void solution(int[] numbers, String hand) {
        int[] leftHandSpot = {3,0};
        int[] rightHandSpot = {3,2};
        String answer = "";

        for(int input : numbers) {
            switch (input) {
                case 1: case 4: case 7 :
                    leftHandSpot = KEYPAD[input];
                    answer += "L";
                    break;
                case 3: case 6: case 9 :
                    rightHandSpot = KEYPAD[input];
                    answer += "R";
                    break;
                case 2: case 5: case 8: case 0:
                    String usedHand = chooseHand(leftHandSpot,rightHandSpot,input,hand);
                    if(usedHand == "L") leftHandSpot = KEYPAD[input];
                    if(usedHand == "R") rightHandSpot = KEYPAD[input];
                    answer += usedHand;
                    break;
            }
        }
        System.out.println(answer);
    }

    private static String chooseHand(int[] leftHandSpot, int[] rightHandSpot, int input,String hand) {
        int leftDistance = Math.abs(leftHandSpot[0] - KEYPAD[input][0]) + Math.abs(leftHandSpot[1] - KEYPAD[input][1]);
        int rightDistance = Math.abs(rightHandSpot[0] - KEYPAD[input][0]) + Math.abs(rightHandSpot[1] - KEYPAD[input][1]);

        String usedHand = hand == "right" ? "R" : "L";

        if(leftDistance < rightDistance) {
            usedHand = "L";
        } else if(leftDistance > rightDistance) {
            usedHand = "R";
        }

        return usedHand;
    }
}
