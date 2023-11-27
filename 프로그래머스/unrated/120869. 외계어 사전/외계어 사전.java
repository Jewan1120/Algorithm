class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        next: for (String str : dic) {
            for (String c : spell) {
                if (!str.contains(c)) {
                    continue next;
                }
            }
            answer = 1;
        }
        return answer;
    }
}