class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int size = my_string.length() / m;
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = my_string.substring(i * m, (i + 1) * m);
        }
        for (String str : strings) {
            answer += str.charAt(c - 1);
        }
        return answer;
    }
}