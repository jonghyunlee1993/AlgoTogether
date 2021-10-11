package programmers;

public class CompactString {

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        int answer = solution(s);
        System.out.println(answer);
    }

    public static int solution(String s) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            int result = getSplitedLength(s, i, 1).length();
            answer = i == 1 ? result : (answer > result ? result : answer);
        }

        return answer;
    }

    private static String getSplitedLength(String s, int cutSize, int repeat) {
        if (s.length() < cutSize) {
            return s;
        }
        String result = "";

        String preString = s.substring(0, cutSize);
        String postString = s.substring(cutSize);

        if (!postString.startsWith(preString)) {
            if (repeat == 1) {
                return result += preString + getSplitedLength(postString, cutSize, 1);
            }
            return result += repeat + preString + getSplitedLength(postString, cutSize, 1);
        }

        return result += getSplitedLength(postString, cutSize, repeat + 1);
    }

}
