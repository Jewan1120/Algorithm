class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i < r2; i++) {
            answer += (long) Math.sqrt((long) (r2 + i) * (r2 - i));
            if (i < r1) {
                answer -= (long) Math.sqrt((long) (r1 + i) * (r1 - i));
                if (Math.sqrt((long) (r1 + i) * (r1 - i)) % 1 == 0) {
                    answer++;
                }
            }
        }
        answer += (r2 - r1 + 1);
        return answer * 4;
    }
}