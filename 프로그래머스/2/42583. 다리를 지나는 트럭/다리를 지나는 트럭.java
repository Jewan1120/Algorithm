import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int load = 0;
        Queue<Integer> wait = new LinkedList<>();
        Queue<int[]> move = new LinkedList<>();
        for (int i : truck_weights) {
            wait.add(i);
        }
        while (!wait.isEmpty() || !move.isEmpty()) {
            if (move.isEmpty() || (!wait.isEmpty() && wait.peek() + load <= weight)) {
                int[] truck = {wait.poll(), 1};
                load += truck[0];
                move.add(truck);
            }
            int j = move.size();
            for (int i = 0; i < j; i++) {
                int[] truck = move.poll();
                if (truck[1] < bridge_length) {
                    truck[1]++;
                    move.add(truck);
                } else {
                    load -= truck[0];
                }
            }
            answer++;
        }
        return answer;
    }
}