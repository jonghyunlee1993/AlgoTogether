package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatRoom {

    private static final String ENTER_FORMAT = " 님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = " 님이 나갔습니다.";

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] records) {
        ArrayList<ChatLog> chatLogs = new ArrayList<>();
        HashMap<String, UserInfo> userMap = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String userId = split[1];
            String nickName = null;

            if(command.equals("Enter")) {
                nickName = split[2];
                userMap.put(userId, new UserInfo(userId, nickName));
                chatLogs.add(new ChatLog(command, userId));
            } else if(command.equals("Leave")) {
                chatLogs.add(new ChatLog(command, userId));
            } else {
                nickName = split[2];
                userMap.get(userId).nickName = nickName;
            }
        }

        String[] answer = new String[chatLogs.size()];
        for (int i = 0; i < chatLogs.size(); i++) {
            String answerString = userMap.get(chatLogs.get(i).userId).nickName;
            answerString += chatLogs.get(i).command.equals("Enter") ? ENTER_FORMAT : LEAVE_FORMAT;
            answer[i] = answerString.toString();
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer = " + answer[i]);
        }

        return null;
    }

    private static class ChatLog {

        public String command;
        public String userId;

        public ChatLog(String command, String userName) {
            this.command = command;
            this.userId = userName;
        }
    }

    private static class UserInfo {

        public String userId;
        public String nickName;

        public UserInfo(String userId, String nickName) {
            this.userId = userId;
            this.nickName = nickName;
        }

    }
}
