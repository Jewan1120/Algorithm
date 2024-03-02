import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.replaceFirst("^x", "").split("x+");
        Arrays.sort(answer);
        return answer;
    }
}