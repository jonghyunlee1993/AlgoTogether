package hash;

import java.util.HashMap;

public class NotCompletePlayer {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        solution(participant , completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for (String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);

        for (String player : completion)
            hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0)
                answer = key;
        }
        System.out.println(answer);
        return answer;
    }
}
