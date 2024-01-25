import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int maxScore = 0;
        ArrayList<int[]> win = new ArrayList<>();
        Queue<int[]> rynque = new ArrayDeque<>();
        Queue<Integer> arwQue = new ArrayDeque<>();
        Queue<Integer> idxQue = new ArrayDeque<>();
        rynque.add(new int[11]);
        arwQue.add(n);
        idxQue.add(0);
        while (!rynque.isEmpty()) {
            int[] tmp = rynque.poll();
            int arrow = arwQue.poll();
            int idx = idxQue.poll();
            if (idx < 10) {
                rynque.add(tmp.clone());
                arwQue.add(arrow);
                idxQue.add(idx + 1);
                if (arrow > info[idx]) {
                    arrow -= info[idx] + 1;
                    tmp[idx] = info[idx] + 1;
                    rynque.add(tmp.clone());
                    arwQue.add(arrow);
                    idxQue.add(idx + 1);
                }
            } else {
                if (arrow > 0) {
                    tmp[10] += arrow;
                }
                int apeach = 0;
                int ryan = 0;
                for (int i = 0; i < info.length; i++) {
                    if (info[i] != 0 && tmp[i] <= info[i]) {
                        apeach += 10 - i;
                    }
                }
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i] != 0 && tmp[i] > info[i]) {
                        ryan += 10 - i;
                    }
                }
                if (ryan - apeach >= maxScore) {
                    if (ryan - apeach > maxScore) {
                        win.clear();
                        maxScore = ryan - apeach;
                    }
                    win.add(tmp);
                }
            }
        }
        if (win.isEmpty() || maxScore == 0) {
            answer = new int[] {-1};
        } else {
            int[] order = new int[3];
            for (int i = 0; i < win.size(); i++) {
                for (int j = 10; j > 0; j--) {
                    if (win.get(i)[j] != 0) {
                        if (j > order[1]) {
                            order = new int[] {i, j, win.get(i)[j]};
                        } else if (j == order[1] && order[3] < win.get(i)[j]) {
                            order = new int[] {i, j, win.get(i)[j]};
                        }
                        break;
                    }
                }
            }
            answer = win.get(order[0]);
        }
        return answer;
    }
}