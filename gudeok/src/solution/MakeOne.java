package solution;

import java.util.Scanner;

/**
 * 문제링크 : https://www.acmicpc.net/problem/1463
 */
public class MakeOne {
    public static int[] memory;

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        memory = new int[number + 1];
        System.out.println(makeOne(number));
    }

    private static int makeOne(int a) {
        if(a == 1) return 0;
        if(memory[a] > 0) return memory[a];
        memory[a] = makeOne(a-1) + 1;

        if(a % 2 == 0) {
            int temp = makeOne(a/2) + 1;
            if(memory[a] > temp) {
                memory[a] = temp;
            }
        }

        if(a % 3 == 0) {
            int temp = makeOne(a/3) + 1;
            if(memory[a] > temp) {
                memory[a] = temp;
            }
        }

        return memory[a];
    }
}
