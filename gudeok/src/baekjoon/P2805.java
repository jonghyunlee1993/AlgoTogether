package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 2805
 * 문제 타이틀 : 나무 자르기
 * 정답비율 : 25.855%
 * 문제 링크 : https://www.acmicpc.net/problem/2805
 * 참고 : 이분탐색
 */
public class P2805 {

    private static long treeLength;
    private static long max;
    private static long[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int treeCount = Integer.parseInt(st.nextToken());
        treeLength = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        trees = new long[treeCount];
        max = 0;
        for (int i = 0; i < treeCount; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = max < trees[i] ? trees[i] : max;
        }
        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (long tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= treeLength) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
