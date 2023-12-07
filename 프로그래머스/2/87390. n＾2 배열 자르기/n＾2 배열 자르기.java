class Solution {
    public int[] solution(int n, long left, long right) {
        int key = 0;
        long value = 0;
        int[] answer = new int[(int) (right - left + 1)];
        for (long i = left; i <= right; i++) {
            value = (i % n) + 1;
            if (value <= (i / n)) {
                value = (i / n) + 1;
            }
            answer[key++] = (int) value;
        }
        return answer;
    }
}