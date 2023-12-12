class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowel = "AEIOU";
        int mul = 781;
        for(String str : word.split("")){
            answer += vowel.indexOf(str) * mul + 1;
            mul /= 5;
        }
        return answer;
    }
}