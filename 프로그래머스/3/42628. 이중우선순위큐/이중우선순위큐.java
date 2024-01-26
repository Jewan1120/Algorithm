import java.util.PriorityQueue;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> fque = new PriorityQueue<>();
        PriorityQueue<Integer> bque = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (String operation : operations) {
            String[] part = operation.split(" ");
            if (part[0].equals("I")) {
                fque.add(Integer.parseInt(part[1]));
                bque.add(Integer.parseInt(part[1]));
            } else if (!fque.isEmpty() && !bque.isEmpty()) {
                if (Integer.parseInt(part[1]) > 0) {
                    fque.remove(bque.poll());
                } else {
                    bque.remove(fque.poll());
                }
            }
        }
        if (fque.isEmpty()) {
            answer = new int[2];
        } else {
            answer = new int[] {bque.poll(), fque.poll()};
        }
        return answer;
    }
}