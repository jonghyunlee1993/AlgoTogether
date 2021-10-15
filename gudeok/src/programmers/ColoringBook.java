package programmers;

public class ColoringBook {

    static boolean[][] check;
    static int cnt;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3},
            {0, 0, 0, 3}};
        solution(m, n, picture);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        check = new boolean[m][n];
        cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && check[i][j] == false) {
                    numberOfArea++;
                    dfs(i, j, picture);
                }
                if (cnt > maxSizeOfOneArea) {
                    maxSizeOfOneArea = cnt;
                }
                cnt = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private static void dfs(int x, int y, int[][] picture) {
        check[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
                continue;
            }

            if (picture[x][y] == picture[nx][ny] && !check[nx][ny]) {
                dfs(nx, ny, picture);
            }
        }
    }
}
