import java.util.ArrayDeque;
import java.util.Deque;
public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deq = new ArrayDeque<Integer>();
        if (deq.size() == 0) {
            deq.push(arr[0]);
        }
        for (int i : arr) {
            if (deq.peek() != i) {
                deq.push(i);
            }
        }
        int[] answer = new int[deq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deq.pollLast();
        }
        return answer;
    }
}