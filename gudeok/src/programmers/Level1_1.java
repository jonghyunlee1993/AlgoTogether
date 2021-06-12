package programmers;

import java.util.HashSet;
import java.util.Set;

/***
 * 문제 타이틀: 폰켓몬
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Level1_1 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> removeDuplicateNums = new HashSet<>();
        for(int num : nums)
            removeDuplicateNums.add(num);

        if(removeDuplicateNums.size() > nums.length/2)
            return nums.length/2;

        return removeDuplicateNums.size();
    }
}
