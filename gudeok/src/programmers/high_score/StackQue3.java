package programmers.high_score;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 문제 타이틀: 다리를 지나는 트럭
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class StackQue3 {

    static class Truck {
        int move;
        int weight;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        solution(bridge_length, weight, truck_weights);
    }

    public static void solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int currentWeight = 0;
        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                currentWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                currentWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && currentWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                currentWeight += t.weight;
                moveQ.offer(t);
            }

        }

        System.out.println(answer);

    }
}
