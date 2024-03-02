class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
            if (num_list.length >= 11) {
                for (int n : num_list) {
                    answer += n;
                }
            } else {
                answer = 1;
                for (int n : num_list) {
                    answer *= n;
                }
            }
        return answer;
    }
}