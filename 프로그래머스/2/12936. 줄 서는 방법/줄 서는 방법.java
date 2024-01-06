import java.util.ArrayList;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        k--;
        long f = 1;
        ArrayList<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            f *= i;
            pool.add(i);
        }
        for (int i = 0; i < n; i++) {
            f /= n - i;
            answer[i] = pool.remove((int) (k / f));
            k %= f;
        }
        return answer;
    }
}