import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int point = 0;
        Queue<int[]> process = new LinkedList<>();
        Queue<Integer> priority = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : priorities) {
            int[] task = {i, point};
            point++;
            process.add(task);
            priority.add(i);
        }
        point = 0;
        while (process.size() > 0) {
            int[] task = process.poll();
            if (priority.peek() == task[0]) {
                priority.poll();
                point++;
                if (task[1] == location) {
                    answer = point;
                }
            } else {
                process.add(task);
            }
        }
        return answer;
    }
}