import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public long solution(int n, int[] works) {
        long answer = Long.MAX_VALUE;
        Queue<int[]> wQue = new ArrayDeque<>();
        Queue<boolean[]> chkQue = new ArrayDeque<>();
        Queue<Integer> nQue = new ArrayDeque<>();
        wQue.add(works);
        chkQue.add(new boolean[works.length]);
        nQue.add(n);
        while (!wQue.isEmpty()) {
            int[] wArr = wQue.poll();
            boolean[] chkArr = chkQue.poll();
            int tmpN = nQue.poll();
            if (tmpN == 0) {
                long result = 0;
                for (int i : wArr) {
                    result += Math.pow(i, 2);
                }
                answer = Math.min(answer, result);
                continue;
            }
            for (int i = 0; i < chkArr.length; i++) {
                if (!chkArr[i]) {
                    chkArr[i] = true;
                    for (int j = 1; j <= wArr[i]; j++) {
                        int[] tmpW = wArr.clone();
                        tmpW[i] -= j;
                        wQue.add(tmpW);
                        chkQue.add(chkArr.clone());
                        nQue.add(tmpN - j);
                    }
                    chkArr[i] = false;
                }
            }
        }
        if (answer == Long.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
}