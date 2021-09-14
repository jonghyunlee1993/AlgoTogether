package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 문제번호 : 14889
 * 문제 타이틀 : 스타트와 링크
 * 정답비율 : 47.626%
 * 문제 링크 : https://www.acmicpc.net/problem/14889
 * 참고 : 백 트래킹
 */
public class P14889 {

    static int peopleCount;
    static int[][] stats;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        peopleCount = Integer.parseInt(br.readLine());
        stats = new int[peopleCount][peopleCount];
        visited = new boolean[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < peopleCount; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);
    }

    private static void dfs(int index, int depth) {
        if(depth == peopleCount / 2) {
            teamStatsDiff();
            return;
        }

        for (int i = index; i < peopleCount; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1,depth + 1);
                visited[i] = false;
            }
        }

    }

    private static void teamStatsDiff() {
        int startTeamStats = 0;
        int linkTeamStats = 0;

        for (int i = 0; i < peopleCount - 1; i++) {
            for (int j = i + 1; j < peopleCount; j++) {
                if(visited[i] && visited[j]) {
                    startTeamStats += stats[i][j];
                    startTeamStats += stats[j][i];
                }

                if(!visited[i] && !visited[j]) {
                    linkTeamStats += stats[i][j];
                    linkTeamStats += stats[j][i];
                }
            }
        }

        int statsDiff = Math.abs(startTeamStats - linkTeamStats);
        if(statsDiff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, statsDiff);
    }
}
