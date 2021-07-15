package codility;

import java.util.StringTokenizer;

public class binaryGap {
    public static void main(String[] args) {
        int N = 32;
        System.out.println(solution(N));
    }

    public static int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        String lastNumber = binary.substring(binary.length() - 1);

        String[] test = binary.split("1");
        int loopSize = lastNumber.equals("1") ? test.length : test.length - 1;
        for (int i = 0; i < loopSize; i++) {
            answer = test[i].length() > answer ? test[i].length() : answer;
        }
        return answer;
    }
}
