package hash;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = Arrays.stream(clothes).collect(groupingBy(c -> c[1], mapping(c -> c[0], counting())))
                .values().stream().collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
        return answer;
    }
}
