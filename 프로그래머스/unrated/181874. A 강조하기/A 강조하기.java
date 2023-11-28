class Solution {
    public String solution(String myString) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (c == 'a' || c =='A') {
                sb.append("A");
            } else if (Character.isUpperCase(c)) {
                sb.append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}