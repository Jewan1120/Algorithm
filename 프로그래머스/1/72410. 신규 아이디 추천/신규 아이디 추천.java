class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("(^\\.)|(\\.$)", "");
        if (answer.length() == 0) {
            answer = "a";
        } else if (answer.length() >= 16) {
            answer = answer.substring(0, 15).replaceAll("\\.$", "");
        }
        if (answer.length() <= 2) {
            String tmp = String.valueOf(answer.charAt(answer.length() - 1));
            while (answer.length() < 3) {
                answer = answer.concat(tmp);
            }
        }
        return answer;
    }
}