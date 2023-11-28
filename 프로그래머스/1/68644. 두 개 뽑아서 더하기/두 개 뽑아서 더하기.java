import java.util.TreeSet;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }
        int[] answer = new int[set.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = set.pollFirst();
        }
        return answer;
    }
}