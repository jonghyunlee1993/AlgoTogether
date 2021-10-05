package programmers.high_score;

public class targetNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = solution(numbers, target);
        System.out.println(answer);
    }

    public static int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0);
        return answer;
    }

    private static int dfs(int[] numbers, int target, int depth) {
        if(depth == numbers.length) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            if(target == sum) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        result += dfs(numbers, target, depth + 1);

        numbers[depth] *= -1;
        result += dfs(numbers, target, depth + 1);

        numbers[depth] *= -1;

        return result;


    }

}
