package solution;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * 문제 링크 : https://www.acmicpc.net/problem/9012
 */

public class VaildPS {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bw.write(isValid(bf.readLine()));
            bw.write("\n");
        }
        bw.flush();
    }

    public static String isValid(String s) {
        int length = s.length();
        int checkNumber = 0;
        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == '(') {
                checkNumber += 1;
            } else {
                checkNumber -= 1;
            }
            if(checkNumber < 0) {
                return "NO";
            }
        }
        return checkNumber == 0 ? "YES" : "NO";
    }


    public Callable<String> test() {
        return new Callable<String>() {
            @Override public String call() throws Exception {
                return "test";
            }
        };
    }


}
