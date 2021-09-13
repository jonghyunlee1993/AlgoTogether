package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 문제번호 : 1260
 * 문제 타이틀 : DFS와 BFS
 * 정답비율 : 34.163%
 * 문제 링크 : https://www.acmicpc.net/problem/1260
 * 참고 : DFS와 BFS
 */
public class P1260 {

    static int[][] graph;
    static boolean[] visited = new boolean[1001];
    static int vertexCount, edgeCount;
    static StringBuilder answer = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        vertexCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());
        graph = new int[vertexCount + 1][vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        dfs(startVertex);
        answer.append("\n");
        Arrays.fill(visited, false);

        bfs(startVertex);
        System.out.println(answer);
    }

    private static void bfs(int startVertex) {
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
             startVertex = queue.poll();
            answer.append(startVertex).append(" ");

            for (int i = 1; i <= vertexCount; i++) {
                if (graph[startVertex][i] == 1 && !visited[i]) {
                    queue.add(i);            //모든 값을 q에 넣고, 겉 while문으로 반복
                    visited[i] = true;
                }
            }
        }
        queue.clear();
    }

    private static void dfs(int startVertex) {
        visited[startVertex] = true;
        answer.append(startVertex).append(" ");
        for (int i = 1; i <= vertexCount; i++) {
            if (graph[startVertex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }
}
