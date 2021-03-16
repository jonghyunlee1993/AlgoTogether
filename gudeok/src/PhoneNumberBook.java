import java.util.Arrays;

public class PhoneNumberBook {
    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phoneBook) {
        boolean answer = true;

        Arrays.sort(phoneBook);
        for(int i = 0; i<phoneBook.length-1; i++) {
            if(phoneBook[i+1].contains(phoneBook[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
