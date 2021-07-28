package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

/***
 * 문제번호 : 1260
 * 문제 타이틀 : DFS와 BFS
 * 정답비율 : 33.882%
 * 문제 링크 : https://www.acmicpc.net/problem/1260
 * 참고 : DFS/BFS
 */
public class P1260 {

    static int map[][];
    static boolean visit[];
    static ArrayList<TreeMap<Integer, Integer>> arrayList;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int startNumber = Integer.parseInt(st.nextToken());
        map = new int[vertex + 1][vertex + 1];
        visit = new boolean[vertex + 1];
        arrayList = new ArrayList<>();

        for (int j = 0; j < vertex + 1; j++) {
            Arrays.fill(map[j], 0);
            arrayList.add(new TreeMap<Integer, Integer>());
        }
        Arrays.fill(visit, false);

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int link1 = Integer.parseInt(st.nextToken());
            int link2 = Integer.parseInt(st.nextToken());
            map[link1][link2] = 1;
            map[link2][link1] = 1;
            arrayList.get(link1).put(link2, link1);
            arrayList.get(link2).put(link1, link2);
        }

        dfs(startNumber);
        answer.append("\n");
        Arrays.fill(visit, false);
        bfs(startNumber, vertex);
        System.out.println(answer);
    }

    private static void dfs(int startNumber) {
        visit[startNumber] = true;
        answer.append(startNumber).append(" ");
        TreeMap<Integer, Integer> treemap = arrayList.get(startNumber);
        for (int i : treemap.keySet()) {
            if (visit[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs(int startNumber, int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNumber);
        visit[startNumber] = true;
        while (!queue.isEmpty()) {
            int number = queue.poll();
            answer.append(number).append(" ");
            for (int i = 0; i <= vertex; i++) {
                if (map[number][i] == 1 && visit[i] == false) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
