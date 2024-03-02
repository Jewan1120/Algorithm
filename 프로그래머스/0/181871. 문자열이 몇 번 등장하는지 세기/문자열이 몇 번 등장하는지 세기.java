class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pat.length(); j++) {
                sb.append(myString.charAt(i + j));
            }
            if (sb.toString().equals(pat)) {
                answer++;
            }
        }
        return answer;
    }
}