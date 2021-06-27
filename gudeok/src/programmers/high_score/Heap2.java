package programmers.high_score;

import java.util.*;

/***
 * 문제 타이틀: 디스크 컨트롤러
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Heap2 {

    private static class Job {
        int requestTime;
        int workingTime;

        Job(int requestTime, int workingTime){
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        solution(jobs);
    }

    public static void solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.workingTime - j2.workingTime;
            }
        });

        for(int[] job : jobs) {
            waiting.offer(new Job(job[0], job[1]));
        }

        Collections.sort(waiting, new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                return j1.requestTime - j2.requestTime;
            }
        });

        int answer = 0;
        int count = 0;
        int time = waiting.peek().requestTime;

        while (count < jobs.length) {
            while(!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                pq.offer(waiting.pollFirst());
            }

            if(!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.workingTime;
                answer += time - job.requestTime;
                count++;
            } else {
                time++;
            }
            System.out.println("**********");
            System.out.println(time);
            System.out.println(answer);
        }

//        System.out.println(answer/jobs.length);
    }
}
