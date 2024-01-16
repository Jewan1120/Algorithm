import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k == 0) {
                break;
            }
            que.offer(enemy[i]);
            if (n < enemy[i] && 0 < k) {
                n += que.poll();
                k--;
            } 
            n -= enemy[i];
            answer++;
        }
        return answer;
    }
}