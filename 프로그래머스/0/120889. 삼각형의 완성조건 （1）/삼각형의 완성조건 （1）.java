class Solution {
    public int solution(int[] sides) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : sides) {
            sum += i;
            if (max < i) {
                max = i;
            }
        }
        int answer = sum > 2 * max ? 1 : 2;
        return answer;
    }
}