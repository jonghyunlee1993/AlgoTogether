package programmers.high_score;

import java.util.*;

/***
 * 문제 타이틀: 프린터
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class StackQue2 {
    public static void main(String[] args) {

        //case 1
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;

        //case 2
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }
        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
