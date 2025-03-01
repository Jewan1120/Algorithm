class Solution {
    public int solution(int n, long l, long r) {
        return recursive(1, (long) Math.pow(5, n), l, r);
    }
    
    private int recursive(long s, long e, long l, long r) {
        if (e <= l || r < s)
            return 0;
        if (e - s == 1)
            return 1;
        long size = (e - s + 1) / 5;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 2)
                continue;
            count += recursive(s + i * size, s + (i + 1) * size, l, r);
        }
        return count;
    }
}