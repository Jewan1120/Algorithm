import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Arrays;
class Solution {
    public int solution(int[][] scores) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        int[] st = scores[0];
        int stSum = st[0] + st[1];
        Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        for (int i = 0; i < scores.length; i++) {
            int[] score = scores[i];
            if (st[0] < score[0] && st[1] < score[1])
                return -1;
            int sum = score[0] + score[1];
            boolean flg = false;
            if (sum > stSum) {
                Iterator<int[]> it = pq.iterator();
                while (it.hasNext()) {
                    int[] tmp = it.next();
                    int tmpSum = tmp[0] + tmp[1];
                    if (sum > tmpSum)
                        break;
                    if (score[0] < tmp[0] && score[1] < tmp[1])
                        flg = true;
                }
                if (!flg)
                    pq.add(score);
            }
        }
        return pq.size() + 1;
    }
}