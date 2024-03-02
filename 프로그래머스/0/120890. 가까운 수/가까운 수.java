class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        for (int i : array) {
            if (Math.abs(n - answer) > Math.abs(n - i)) {
                answer = i;
            } else if (Math.abs(n - answer) == Math.abs(n - i)) {
                answer = answer < i ? answer : i;
            }
        }
        return answer;
    }
}