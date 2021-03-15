package basic;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int x = sc.nextInt();
        move(x , 1 , 3);
    }

    public static void move(int count , int from , int to) {
        if(count > 1)
            move(count -1 , from , 6 - from - to );

        System.out.println("원반" + count +  "를 " + from + "기둥에서 " + to + "기둥으로 옮김");

        if(count > 1)
            move(count - 1 , 6 - from - to , to);

    }
}
