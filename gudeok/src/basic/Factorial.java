package basic;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오.");
        int x = sc.nextInt();
        System.out.println(solution(x));
    }

    public static int solution(int x) {
        if( x > 0 )
            return x * solution(x -1);
        else
            return 1;
    }
}
