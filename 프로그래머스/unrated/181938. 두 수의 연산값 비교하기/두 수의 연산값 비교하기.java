class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        int result1 = Integer.parseInt(sb.toString());
        int result2 = 2 * a * b;
        return result1 >= result2 ? result1 : result2;
    }
}