import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i : scoville) {
            que.add(i);
        }
        while (que.peek() < K && que.size() >= 2) {
            que.add(que.poll() + que.poll() * 2);
            answer++;
        }
        if(que.peek() < K) answer = -1;
        return answer;
    }
}