class Solution {
    public int solution(int[] common) {
        int a1 = common[1] - common[0];
        int a2 = common[2] - common[1];
        int n = common[common.length - 1];
        return a1 == a2 ? n + a1 : n * common[1] / common[0];
    }
}