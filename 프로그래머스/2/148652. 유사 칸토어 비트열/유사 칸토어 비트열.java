class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        next: for (long i = l; i <= r; i++) {
            long tmp = i;
            long cnt = n - 1;
            while (cnt > 0) {
                long div = (long) Math.pow(5, cnt);
                if (tmp / div == 2 || tmp % div == 3) {
                    continue next;
                }
                tmp %= div;
                cnt--;
            }
            answer++;
        }
        return answer;
    }
}