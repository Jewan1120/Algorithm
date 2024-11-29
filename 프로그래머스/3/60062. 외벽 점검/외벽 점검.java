import java.util.Arrays;
class Solution {
    int w, d;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        w = weak.length;
        d = dist.length;
        Arrays.sort(dist);
        judge(0, 0, 0, n, weak, dist);
        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    private void judge(int depth, int p, int visited, int n, int[] weak, int[] dist) {
        if (visited == (1 << w) - 1) {
            answer = Math.min(answer, depth);
            return;
        }
        if (depth == d || depth >= answer) {
            return;
        }
        int move = dist[d - 1 - depth];
        for (int i = p; i < w; i++) {
            int next = visited;
            int l = weak[i], r = l + move;
            int idx = i;
            while (isPossible(l, r, weak[idx], weak[idx] + n)) {
                if ((next & (1 << idx)) == 1)
                    break;
                next |= (1 << idx);
                idx++;
                if (idx >= w)
                    idx %= w;
            }
            judge(depth + 1, idx, next, n, weak, dist);
        }
    }

    private boolean isPossible(int l, int r, int point, int other) {
        return (l <= point && point <= r) || (l <= other) && (other <= r);
    }
}