package hash;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {
    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for(int i=0; i<phoneBook.length-1;i++) {
            if(phoneBook[i+1].startsWith(phoneBook[i])) {
                return false;
            }
        }
        return true;
    }
}
