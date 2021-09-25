package solution;

import java.util.Arrays;
import java.util.stream.Stream;

public class W1 {
    public static void main(String[] args) {
        int N = 33285;
        int result = solution(N);
        System.out.println(result);
    }

    public static int solution(int n) {
        int[] numbers = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        StringBuilder maxNumber = new StringBuilder();
        StringBuilder minNumber = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            maxNumber.append(numbers[i]);
            minNumber.append(numbers[numbers.length - i -1]);
        }

        System.out.println(maxNumber);
        System.out.println(minNumber);
        return Integer.parseInt(maxNumber.toString())
            + Integer.parseInt(minNumber.toString());
    }
}
