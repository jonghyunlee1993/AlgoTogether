package codility;

public class Y_1 {
    public static void main(String[] args) {
        String G = "PPPPRRSSSSS";
        System.out.println(solution(G));
    }

    public static int solution(String g) {
        int answer = 0;
        char[] francoStartegy = {'R','S','P'};
        char[] gioStrategy = g.toCharArray();

        for (int i = 0; i < francoStartegy.length; i++) {
            int point = 0;
            for (int j = 0; j < gioStrategy.length; j++) {
                if (francoStartegy[i] == gioStrategy[j]) {
                    point += 1;
                } else if (francoStartegy[i] == 'R' && gioStrategy[j] == 'S') {
                    point += 2;
                } else if (francoStartegy[i] == 'S' && gioStrategy[j] == 'P') {
                    point += 2;
                } else if (francoStartegy[i] == 'P' && gioStrategy[j] == 'R') {
                    point += 2;
                }
            }
            answer = answer < point ? point : answer;
        }

        return answer;
    }
}
