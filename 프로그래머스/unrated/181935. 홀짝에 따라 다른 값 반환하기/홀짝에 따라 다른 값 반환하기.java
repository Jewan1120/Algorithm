class Solution {
    public int solution(int n) {
        return n % 2 == 1 ? (int) Math.pow(n + 1, 2) / 4 : n * (n + 1) * (n + 2) / 6;
    }
}