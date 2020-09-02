package algorithm;

public class Template {
    public static void main(String[] args) {
        String input = "+1234";
        System.out.print("answer is ");
        System.out.println(solution(input));
    }

    public static int solution(String number) {
        return Integer.parseInt(number);
    }
}
