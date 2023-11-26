class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(phone_number.length() - 4));
        sb.append(phone_number.substring(phone_number.length() - 4));
        return sb.toString();
    }
}