package programmers;


/***
 * 문제 타이틀: 내적
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/70128
 */
public class Level1_3 {
    public static void main(String[] args) {

        //case 1
//        int[] a = {1,2,3,4};
//        int[] b = {-3,-1,0,2};

        //case 2
        int[] a = {-1,0,1};
        int[] b = {1,0,-1};
        System.out.println(solution(a,b));
    }

    public static int solution(int[] a , int[] b) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}
