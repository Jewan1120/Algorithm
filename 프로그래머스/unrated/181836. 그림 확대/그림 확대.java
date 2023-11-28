class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < picture.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < picture[i].length(); j++) {
                for (int n = 0; n < k; n++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            for (int j = i * k; j < (i + 1) * k; j++) {
                answer[j] = sb.toString();
            }
        }
        return answer;
    }
}