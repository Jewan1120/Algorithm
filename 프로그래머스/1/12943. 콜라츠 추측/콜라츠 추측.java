class Solution {
    public int solution(int num) {
        long tmp = (long) num;
        int count = 0;
        while (tmp > 1) {
            if (tmp % 2 == 0) {
                tmp /= 2;
            } else {
                tmp = (tmp * 3) + 1;
            }
            count++;
        }
        return count <= 500 ? count : -1;
    }
}