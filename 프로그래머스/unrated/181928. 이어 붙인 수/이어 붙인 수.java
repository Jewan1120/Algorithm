class Solution {
    public int solution(int[] num_list) {
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        for (int i : num_list) {
            if (i % 2 == 0) {
                result1.append(i);
            } else {
                result2.append(i);
            }
        }
        int answer = Integer.parseInt(result1.toString()) + Integer.parseInt(result2.toString());
        return answer;
    }
}