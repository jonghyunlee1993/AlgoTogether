package codility;

public class Y_4 {
    private static Integer[][] dp;
    private static int[][] map;
    static int vertical;
    static int horizontal;

    public static void main(String[] args) {
        String L1 = "..xx.x.";
        String L2 = "x.x.x..";
        dp = new Integer[L1.length() + 1][L2.length() + 1];
        vertical = 2;
        horizontal = L1.length();
        map = new int[vertical + 1][horizontal + 1];

        for (int j = 0; j < L1.length(); j++) {
            if(L1.charAt(j) == 'x') {
                map[0][j] = 1;
            } else if (L1.charAt(j) == '.') {
                map[0][j] = 0;
            }

            if(L2.charAt(j) == 'x') {
                map[1][j] = 1;
            } else if (L2.charAt(j) == '.') {
                map[1][j] = 0;
            }
        }
        findRoad(0,0);

        for (int i = 0; i < horizontal; i++) {
            System.out.println("==========");
            System.out.println(dp[0][i]);
            System.out.println(dp[1][i]);
        }
        solution(L1,L2);
    }

    public static int solution(String l1, String l2) {
        int answer = 0;



        return answer;
    }

    private static int findRoad(int x,int y) {
        if(x == vertical-1 && y == horizontal-1) {
            return 1;
        }

        if(dp[x][y] == null) {
            dp[x][y] = 0;
            // 위로 이동
            if(x > 0 && map[x][y] > map[x-1][y]) {
                dp[x][y] += findRoad(x-1, y);
            }
            // 아래로 이동
            if(x < vertical-1 && map[x][y] > map[x+1][y]) {
                dp[x][y] += findRoad(x+1, y);
            }
            // 오른쪽으로 이동
            if(y < horizontal-1 && map[x][y] > map[x][y+1]) {
                dp[x][y] += findRoad(x, y+1);
            }
        }
        return dp[x][y];
    }
}
