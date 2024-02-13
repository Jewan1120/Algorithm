import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Deque<Integer> deqA = new ArrayDeque<>();
        Deque<Integer> deqB = new ArrayDeque<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            deqA.addFirst(A[i]);
            deqB.addFirst(B[i]);
        }
        for(int i = 0; i < A.length; i++){
            if (deqA.peek() < deqB.peek()){
                deqA.poll();
                deqB.poll();
                answer++;
            } else {
                deqA.poll();
                deqB.pollLast();
            }
        }
        return answer;
    }
}