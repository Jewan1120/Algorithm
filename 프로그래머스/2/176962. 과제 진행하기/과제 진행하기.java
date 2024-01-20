import java.util.PriorityQueue;
import java.util.Stack;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<String[]> planQue =
                new PriorityQueue<>((o1, o2) -> Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        Stack<String[]> planStk = new Stack<>();
        for (String[] plan : plans) {
            int time = Integer.parseInt(plan[1].substring(0, 2)) * 60
                    + Integer.parseInt(plan[1].substring(3, 5));
            plan[1] = String.valueOf(time);
            planQue.add(plan);
        }
        int nowTime = 0;
        while (!planQue.isEmpty()) {
            if (planStk.isEmpty()) {
                planStk.push(planQue.poll());
                nowTime = Integer.parseInt(planStk.peek()[1]);
                continue;
            }
            String[] plan = planStk.pop();
            int nowEndTime = nowTime + Integer.parseInt(plan[2]);
            int nextStartTime = Integer.parseInt(planQue.peek()[1]);
            if (nowEndTime <= nextStartTime) {
                nowTime = nowEndTime;
                answer[idx++] = plan[0];
            } else {
                plan[2] = String.valueOf(nowEndTime - nextStartTime);
                planStk.push(plan);
                planStk.push(planQue.poll());
                nowTime = Integer.parseInt(planStk.peek()[1]);
            }
        }
        while (!planStk.isEmpty()) {
            answer[idx++] = planStk.pop()[0];
        }
        return answer;
    }
}