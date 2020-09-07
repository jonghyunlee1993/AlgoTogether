package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HelloWorld {
    public static void main(String args[]) throws IOException {
//        int hello1 = hello1();
//        System.out.println(hello1);
//        int hello2 = hello2();
//        System.out.println(hello2);

//        hello3();
//        hello3_2();
        hello4();



    }

    public static int hello1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        return a + b;
    }

    public static int hello2() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        return a + b;
    }

    public static void hello3() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result[] = new int[a];
        for(int i = 0; i < a; i++) {
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            result[i] = b1 + b2;
        }
        sc.close();

        for(int i = 0; i < a; i++) {
            System.out.println(result[i]);
        }
    }

    public static void hello3_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void hello4() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
        sc.close();
    }
}
