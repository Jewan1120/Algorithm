class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        for (int i = count; i > 0; i--) {
            answer -= price * i;
        }
        return answer > 0 ? 0 : Math.abs(answer);
    }
}