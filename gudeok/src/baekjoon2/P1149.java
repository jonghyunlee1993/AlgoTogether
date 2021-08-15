package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149 {

    private static Integer[][] dp;
    private static Integer[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(br.readLine());
        dp = new Integer[houseCount][3];
        cost = new Integer[houseCount][3];

        for (int i = 0; i < houseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        int answer = Math.min(
            getMinCost(houseCount - 1,0),Math.min(
                getMinCost(houseCount - 1,1),getMinCost(houseCount - 1,2)));

        System.out.println(answer);

    }

    private static int getMinCost(int index, int color) {
        if(dp[index][color] == null) {
            if(color == 0) {
                dp[index][0] = Math.min(getMinCost(index - 1, 1),getMinCost(index - 1, 2)) + cost[index][0];
            } else if (color == 1) {
                dp[index][1] = Math.min(getMinCost(index - 1, 0),getMinCost(index - 1, 2)) + cost[index][1];
            } else if (color == 2) {
                dp[index][2] = Math.min(getMinCost(index - 1, 0),getMinCost(index - 1, 1)) + cost[index][2];
            }
        }
        return dp[index][color];
    }

}
