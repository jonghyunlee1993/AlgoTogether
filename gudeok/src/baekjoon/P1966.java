package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1966
 * 문제 타이틀 : 프린터 큐
 * 정답비율 : 55.825%
 * 문제 링크 : https://www.acmicpc.net/problem/1966
 * 참고 : 큐/덱
 */
public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < caseCount; i++) {
            StringTokenizer docsInfo = new StringTokenizer(br.readLine(), " ");
            StringTokenizer docsPriority = new StringTokenizer(br.readLine(), " ");

            int docsAmount = Integer.parseInt(docsInfo.nextToken());
            int order = Integer.parseInt(docsInfo.nextToken());
            LinkedList<int[]> printQueue = new LinkedList<>();
            for (int j = 0; j < docsAmount; j++) {
                printQueue.offer(new int[]{j, Integer.parseInt(docsPriority.nextToken())});
            }
            answer.append(getDocsOrder(order,printQueue)).append("\n");
        }

        System.out.println(answer);
    }

    private static int getDocsOrder(int order, LinkedList<int[]> printQueue) {
        int count = 0;
        while (!printQueue.isEmpty()) {
            int[] front = printQueue.poll();

            boolean isMax = true;
            for (int i = 0; i < printQueue.size(); i++) {
                if(front[1] < printQueue.get(i)[1]) {
                    printQueue.add(front);
                    for (int j = 0; j < i; j++) {
                        printQueue.add(printQueue.poll());
                    }
                    isMax = false;
                    break;
                }
            }

            if(isMax == false) {
                continue;
            }

            count++;
            if(front[0] == order) {
                break;
            }
        }

        return count;
    }
}
