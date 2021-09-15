package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * 문제 타이틀: 배달
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Delivery {

    private static ArrayList<Edge>[] edges;
    private static int[] minDistance;

    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(solution(N,road,K));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        //초기화 과정
        edges = new ArrayList[N + 1];
        minDistance = new int[N + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            edges[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edges[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }

        minDistance[1] = 0;
        dijkstra();
        for (int cost : minDistance) {
            if (cost <= K) {
                answer++;
            }
        }

        return answer;
    }

    private static void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1,0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int weight = edge.weight;
            if (minDistance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < edges[vertex].size(); i++) { // 해당 도시와 연결되 있는 도시들 탐색
                int vertex2 = edges[vertex].get(i).vertex;
                int weight2 = edges[vertex].get(i).weight + weight;
                if (minDistance[vertex2] > weight2) { // 최단경로 세팅
                    minDistance[vertex2] = weight2;
                    queue.add(new Edge(vertex2, weight2));
                }
            }

        }
    }

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
