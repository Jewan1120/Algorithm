class Solution {
    public int solution(String t, String p) {
        long longP = Long.parseLong(p);
        int lengthT = t.length();
        int lengthP = p.length();
        int answer = 0;
        for (int i = 0; i < lengthT - lengthP + 1; i++) {
            String tmp = t.substring(i, i + lengthP);
            if (longP >= Long.parseLong(tmp)) {
                answer++;
            }
        }
        return answer;
    }
}