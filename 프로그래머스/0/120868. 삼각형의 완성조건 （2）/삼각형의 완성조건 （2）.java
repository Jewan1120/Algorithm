class Solution {
    public int solution(int[] sides) {
        return sides[0] <= sides[1] ? sides[0] * 2 - 1 : sides[1] * 2 - 1;
    }
}