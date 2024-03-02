class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] parts = s.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("Z")) {
                answer -= Integer.parseInt(parts[i - 1]);
            } else {
                answer += Integer.parseInt(parts[i]);
            }
        }
        return answer;
    }
}