package programmers;

import java.math.BigInteger;

public class NormalSquare {
    public static void main(String[] args) {
        int W = 8;
        int H = 12;
        System.out.println(solution(W,H));
    }

    public static long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}
