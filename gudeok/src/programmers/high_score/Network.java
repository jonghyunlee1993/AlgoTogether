package programmers.high_score;

public class Network {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int answer = solution(n, computers);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, check, i);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int[][] computers, boolean[] check, int start) {
        check[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !check[i]) {
                dfs(computers, check, i);
            }
        }

    }
}
