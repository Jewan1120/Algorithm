import java.util.Stack;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> task = new Stack<Integer>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (task.isEmpty() || task.get(0) >= progress) {
                task.add(progress);
            } else {
                int[] tmp = new int[answer.length + 1];
                System.arraycopy(answer, 0, tmp, 0, answer.length);
                tmp[answer.length] = task.size();
                answer = tmp;
                task.clear();
                task.add(progress);
            }
        }
        int[] tmp = new int[answer.length + 1];
        System.arraycopy(answer, 0, tmp, 0, answer.length);
        tmp[answer.length] = task.size();
        answer = tmp;
        return answer;
    }
}