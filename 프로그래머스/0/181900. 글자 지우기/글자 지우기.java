class Solution {
    public String solution(String my_string, int[] indices) {
        String[] myChars = my_string.split("");
        StringBuilder sb = new StringBuilder();
        for (int i : indices) {
            myChars[i] = "";
        }
        for (String str : myChars) {
            sb.append(str);
        }
        return sb.toString();
    }
}