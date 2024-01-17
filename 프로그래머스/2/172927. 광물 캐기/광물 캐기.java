import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = Integer.MAX_VALUE;
        int[][] fArr = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int[][] nArr = new int[(int) Math.ceil((double) minerals.length / 5)][3];
        int idx = 0;
        for (int i = 0; i < minerals.length; i++) {
            int mineral = 0;
            switch (minerals[i]) {
                case "iron": {
                    mineral = 1;
                    break;
                }
                case "stone": {
                    mineral = 2;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (picks[j] == 0) {
                    continue;
                }
                nArr[idx][j] += fArr[j][mineral];
            }
            if ((i + 1) % 5 == 0) {
                idx++;
            }
        }
        Queue<int[]> que = new ArrayDeque<>();
        Queue<Integer> minQue = new ArrayDeque<>();
        Queue<Integer> idxQue = new ArrayDeque<>();
        que.add(picks);
        minQue.add(0);
        idxQue.add(0);
        while (!que.isEmpty()) {
            int[] pic = que.poll();
            int min = minQue.poll();
            idx = idxQue.poll();
            boolean chk = false;
            for (int i = 0; i < 3; i++) {
                if (pic[i] == 0) {
                    continue;
                } else if (idx < nArr.length) {
                    chk = true;
                    pic[i]--;
                    que.add(pic.clone());
                    pic[i]++;
                    minQue.add(min + nArr[idx][i]);
                    idxQue.add(idx + 1);
                }
            }
            if (!chk) {
                answer = Math.min(answer, min);
            }
        }
        return answer;
    }
}