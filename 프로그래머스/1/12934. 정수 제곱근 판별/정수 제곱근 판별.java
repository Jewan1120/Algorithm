class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt % 1 == 0 ? (long) Math.pow(sqrt + 1, 2) : -1;
    }
}